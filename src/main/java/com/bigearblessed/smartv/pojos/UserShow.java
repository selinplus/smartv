package com.bigearblessed.smartv.pojos;

import java.util.List;

import com.bigearblessed.smartv.entities.Role;

public class UserShow {
	private String username;
	private String userid;
	private String password;
	private String phone;
	private DepartmentShow dept;
	private List<Role> role;

	public UserShow(String username, String userid, String password, String phone, DepartmentShow dept) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.phone = phone;
		this.dept = dept;
	}
	public UserShow(List<Role> role) {
		super();
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DepartmentShow getDept() {
		return dept;
	}
	public void setDept(DepartmentShow dept) {
		this.dept = dept;
	}
	
	public UserShow(String username, String userid, String password, DepartmentShow dept) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.dept = dept;
	}

	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public UserShow(String username, String userid, String password, String phone, DepartmentShow dept,
			List<Role> role) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
		this.phone = phone;
		this.dept = dept;
		this.role = role;
	}
	public UserShow() {
		super();
		// TODO Auto-generated constructor stub
	}
}
