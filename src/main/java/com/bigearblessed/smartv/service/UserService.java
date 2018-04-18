package com.bigearblessed.smartv.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.entities.User;
import com.bigearblessed.smartv.repositories.UserRepository;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    	
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*
     * 登陆
     */
   public int login(String username,String password) {
	   User u =  userRepository.findByUsername(username);
	   if(u==null) {
		   return -1;
	   }else if(!passwordEncoder().matches(password,u.getPassword())) {
		   return 0;
	   }
	   return 1;
   }
    
    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void save(User user){
       user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
    
    public int updateUser(String username,User user) {
       user.setPassword(passwordEncoder().encode(user.getPassword()));
    	return userRepository.updateById(user.getDept().getDeptName(), user.getPhone(), user.getPassword(), user.getUsername(),new Department(user.getDept().getDeptId()), username);
   }
    public int deleteUser(String username) {
    	return userRepository.deleteUsername(username);
    }
    
    
}
