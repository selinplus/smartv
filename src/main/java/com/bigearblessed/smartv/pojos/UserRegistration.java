package com.bigearblessed.smartv.pojos;

import java.util.List;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.entities.Role;

public class UserRegistration {

	private String userid;
	private String username;
    private String password;
    private String passwordConfirmation;
    private String phone;
    private Department dept;
    private Role role;


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	


	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public UserRegistration(String userid, String username, String password, String passwordConfirmation, String phone,
			Department dept) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.phone = phone;
		this.dept = dept;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


    public UserRegistration() {
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

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }


	public UserRegistration(String userid, String username, String password, String passwordConfirmation, String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.phone = phone;
	
	}
    
}
