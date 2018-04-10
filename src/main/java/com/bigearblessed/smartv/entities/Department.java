package com.bigearblessed.smartv.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Department {

	@Id
	private String id;
	
	private String name;
	@OneToOne
	@MapsId
	private Department parent;
	
	private boolean isStandalone;

	private boolean isCustomer;
	
	private Date createdDate;
	
	private Date modeifyDate;
	
	public Department(String id) {
		this.id = id;
	}

	public Department() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public boolean isStandalone() {
		return isStandalone;
	}

	public void setStandalone(boolean isStandalone) {
		this.isStandalone = isStandalone;
	}

	public boolean isCustomer() {
		return isCustomer;
	}

	public Date getModeifyDate() {
		return modeifyDate;
	}

	public void setModeifyDate(Date modeifyDate) {
		this.modeifyDate = modeifyDate;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
}
