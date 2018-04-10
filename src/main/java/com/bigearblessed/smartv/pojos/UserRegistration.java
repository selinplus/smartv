package com.bigearblessed.smartv.pojos;


public class UserRegistration {

    private String username;
    private String password;
    private String passwordConfirmation;
    private String deptId;
    public UserRegistration() {
    }

    public UserRegistration(String username, String password, String passwordConfirmation, String deptId) {
        this.username = username;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.deptId = deptId;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
    
    
}
