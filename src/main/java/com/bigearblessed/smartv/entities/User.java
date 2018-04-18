package com.bigearblessed.smartv.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    private String userid;
    private String username;

    @JsonIgnore
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    private boolean isOuter;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Department dept;
    private String phone;
    private String deptName;
  

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public User(String userid, String username, String password, List<Role> roles, boolean isOuter, Department dept,
			String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.isOuter = isOuter;
		this.dept = dept;
		this.phone = phone;
	}

	public User() {}

    public User(String userid,String username, String password, List<Role> roles, Department dept,String phone,String deptName) {
    	this.userid = userid;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.dept = dept;
        this.phone = phone;
        this.deptName = deptName;
   
    }
    public User(String userid,String username, String password, Department dept,String phone,String deptName) {
    	this.userid = userid;
        this.username = username;
        this.password = password;
        this.dept = dept;
        this.phone = phone;
        this.deptName = deptName;
    }
    public User(String username, String password,String phone, Department dept) {
        this.username = username;
        this.password = password;
        this.dept = dept;
  
        this.phone = phone;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isOuter() {
		return isOuter;
	}

	public void setOuter(boolean isOuter) {
		this.isOuter = isOuter;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}


    
}

