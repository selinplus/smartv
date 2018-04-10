package com.bigearblessed.smartv.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.entities.Role;
import com.bigearblessed.smartv.entities.User;
import com.bigearblessed.smartv.pojos.UserRegistration;
import com.bigearblessed.smartv.service.UserService;


@Controller
public class UserController {
	 	@Autowired
	    private UserService userService;

	    @PostMapping(value = "/user/register")
	    public String register(@RequestBody UserRegistration userRegistration){
	        if(!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation()))
	            return "两次密码不一致";
	        else if(userService.getUser(userRegistration.getUsername()) != null)
	            return "用户名已存在";

	        
	        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
	        if(pattern.matcher(userRegistration.getUsername()).find())
	            return "用户名含非法字符";

	        userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"), new Role("ACTUATOR")), new Department("OUTER")));
	        return "用户已创建";
	    }

	    @GetMapping(value = "/api/user/list")
	    @ResponseBody
	    public List<User> users(){
	        return userService.getAllUsers();
	    }

//	    @GetMapping(value = "/logouts")
//	    public void logout(@RequestParam (value = "access_token") String accessToken){
//	        tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken));
//	    }

	    @GetMapping(value ="/api/user/getUsername")
	    @ResponseBody
	    public String getUsername(){
	        return SecurityContextHolder.getContext().getAuthentication().getName();
	    }
}
