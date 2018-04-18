package com.bigearblessed.smartv.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {

    public Role(int id, String roleName, String roleDescribe) {
		this.id = id;
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
	}
	@Id
    @GeneratedValue
    int id;
    String roleName;
    String roleDescribe;
    Role() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescribe() {
		return roleDescribe;
	}
	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}
	public Role(String roleName, String roleDescribe) {
	
		this.roleName = roleName;
		this.roleDescribe = roleDescribe;
	}


}
