package com.bigearblessed.smartv.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.entities.Role;
import com.bigearblessed.smartv.entities.User;
import com.bigearblessed.smartv.pojos.DepartmentShow;
import com.bigearblessed.smartv.pojos.UserEdit;
import com.bigearblessed.smartv.pojos.UserRegistration;
import com.bigearblessed.smartv.pojos.UserShow;
import com.bigearblessed.smartv.service.UserService;


@RestController
public class UserController {
	 	@Autowired
	    private UserService userService;

	    @PostMapping(value = "/register")
	    public Map<String, String> register(@RequestBody UserRegistration userRegistration){
	    	 Map<String, String> map = new HashMap<String,String>();
	     try {
	    	 if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())) {
	    		    map.put("register", "false");
	    	        map.put("msg", "两次密码不一致！！！");
		            return map;
	    	 }
		      else if(userService.getUser(userRegistration.getUsername()) != null) {
		            map.put("register", "false");
    	        	map.put("msg", "该用户名已存在！！！");
    	        	return map;
		      }
		      Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		      if(pattern.matcher(userRegistration.getUsername()).find()) {
		      map.put("register", "false");
		      map.put("msg", "用户名含非法字符！！！");
		      return map;
		      }
		        	
		       String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		       userService.save(new User(uuid,userRegistration.getUsername(), userRegistration.getPassword(),Arrays.asList(new Role("user","普通用户")),new Department(userRegistration.getDept().getDeptId()),userRegistration.getPhone(),userRegistration.getDept().getDeptName()));
		       	map.put("register", "true");
		       	map.put("msg", "注册成功！！！");
		       	return map; 
		       
	     }catch (Exception e) {
			// TODO: handle exception
	    	 map.put("register", "false");
     		 map.put("msg", "部门不存在！！！");
     		return map;
	    
		}
	    	
	    }
	    
//	    @PostMapping(value = "/login")
//	    public Map<String, String>  login(String username,String password) {
//	    	System.out.println(username+"用户名");
//	    	Map<String, String>  map = new HashMap<String,String>();
//	    	int i =  userService.login(username,password);
//	    	if(i==-1) {
//	    		map.put("login", "fasle");
//	    		map.put("msg","用户名不存在！！！");
//	    		return map;
//	    	}else if(i==0) {
//	    		map.put("login", "fasle");
//	    		map.put("msg","密码错误！！！");
//	    		return map;
//	    	}
//	    	map.put("login", "true");
//    		map.put("msg","登录成功！！！");
//    		return map;
//	    }
	
	    
//	    @GetMapping(value = "/login")
//	    public Map<String, String>  loginT(@RequestBody UserRegistration user) {
//	    	System.out.println(user.getPassword()+"get");
//	    	Map<String, String>  map = new HashMap<String,String>();
//	    	//int i =  userService.login(user.getUsername(),user.getPassword());
//	    	int i = 1;
//	    	if(i==-1) {
//	    		map.put("login", "fasle");
//	    		map.put("msg","用户名不存在！！！");
//	    		return map;
//	    	}else if(i==0) {
//	    		map.put("login", "fasle");
//	    		map.put("msg","密码错误！！！");
//	    		return map;
//	    	}
//	    	map.put("login", "true");
//    		map.put("msg","登录成功！！！");
//    		return map;
//	    }

	    @GetMapping(value = "/main/users/getAllUser")
	    @ResponseBody
	    public Map<String,List<UserShow>> users(){
	    	Map<String,List<UserShow>> map = new HashMap<String,List<UserShow>>();
	    	List<User> list = userService.getAllUsers();
	    	List<UserShow> users = new ArrayList<UserShow>();
	    	List<Role> role = new ArrayList<Role>();
	    	for(int i=0;i<list.size();i++) {
	    	  
	    	  List<Role> listRole = list.get(i).getRoles();

	    	  for(int j=0;j<listRole.size();j++) {
	    		  System.out.println("i="+i+"j="+j);
	    		  role.add(new Role(listRole.get(j).getId(),listRole.get(j).getRoleName(), listRole.get(j).getRoleDescribe()));
	    	  }
	    	  users.add(new UserShow(list.get(i).getUsername(),list.get(i).getUserid(),list.get(i).getPassword(),list.get(i).getPhone(),new DepartmentShow(list.get(i).getDept().getDeptName(), list.get(i).getDept().getSupperDeptName(),list.get(i).getDept().getDeptId(),list.get(i).getDept().getSupperDeptId().getDeptId()),role));
	    	}
	   
	    	map.put("users", users);
	       return map;
	    
	    }

//	    @GetMapping(value = "/logouts")
//	    public void logout(@RequestParam (value = "access_token") String accessToken){
//	        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
//	    }

	    @GetMapping(value ="/main/user/getUsername")
	    @ResponseBody
	    public String getUsername(){
	        return SecurityContextHolder.getContext().getAuthentication().getName();
	    }
	    
	    
	   @PostMapping(value ="/main/users/addUser")
	    public Map<String, String> addUser(@RequestBody UserRegistration adduser){
	    	Map<String,String> map = new HashMap<String,String>();
	    	User user = new User();
	    	if(userService.getUser(adduser.getUsername()) != null) {
	    		map.put("addUser", "false");
	    		map.put("msg", "用户名已存在");
	    		return map;
	    	}
		    Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		    if(pattern.matcher(adduser.getUsername()).find()) {
		    map.put("addUser", "false");
		    map.put("msg", "用户名已存在");
		    return map;
		   }
	        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    	user.setUserid(uuid); 
	    	user.setPassword(adduser.getPassword());
	    	user.setPhone(adduser.getPhone());
	    	user.setUsername(adduser.getUsername());
	    	user.setDept(new Department(adduser.getDept().getDeptId()));
	    	user.setDeptName(adduser.getDept().getDeptName());
	    	user.setRoles(Arrays.asList(new Role(adduser.getRole().getRoleName(), adduser.getRole().getRoleDescribe())));
	    	
	    
	        userService.save(user);
	        map.put("addUser", "true");
	        map.put("msg", "用户添加成功!!!");
	        return map;
	    }
	    
	   @PostMapping(value = "/main/users/updateUser")
	   public Map<String, String> updateUser(@RequestBody UserEdit userEdit){
			Map<String,String> map = new HashMap<String,String>();
		
			UserRegistration originalUser = userEdit.getOriginalUser();
			UserRegistration modifiedUser = userEdit.getModifiedUser();
			User user = 
			new User(modifiedUser.getUsername(),modifiedUser.getPassword(),modifiedUser.getPhone(),new Department(modifiedUser.getDept().getDeptId(),modifiedUser.getDept().getDeptName(),modifiedUser.getDept().getSupperDeptId(),modifiedUser.getDept().getSupperDeptName()));
			int i = userService.updateUser(originalUser.getUsername(),user);
			if(i==1) {
	    		map.put("updateUser", "true");
	    		map.put("msg", "用户修改成功！！！");
	    	}else {
	    		map.put("updateUser", "false");
	    		map.put("msg", "用户修改失败！！！");
	    	}
			return map;
	   }
	   
	   @PostMapping(value = "/main/users/deleteUser")
	   public Map<String,String> deleteUser(@RequestBody User user){
		   Map<String,String> map = new HashMap<String,String>();
		   int i = userService.deleteUser(user.getUsername());
		   if(i==1) {
	    		map.put("updateUser", "true");
	    		map.put("msg", "用户删除成功！！！");
	    	}else {
	    		map.put("updateUser", "false");
	    		map.put("msg", "用户删除失败！！！");
	    	}
		   return map;
	   }
}
