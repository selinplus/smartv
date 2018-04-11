package com.bigearblessed.smartv.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @JsonIgnore
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    private boolean isOuter;
    @OneToOne
    private Department department;
    User() {}

    public User(String username, String password, List<Role> roles, Department department) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.department = department;
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

    public Long getId() {
        return id;
    }

	public boolean isOuter() {
		return isOuter;
	}

	public void setOuter(boolean isOuter) {
		this.isOuter = isOuter;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
    
}

