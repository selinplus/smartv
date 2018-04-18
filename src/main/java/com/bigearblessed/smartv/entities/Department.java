package com.bigearblessed.smartv.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Department {

	@Id
	private String deptId;
	
	private String deptName;
	

	private boolean isStandalone;

	private boolean isCustomer;
	
	private Date createdDate;
	
	private Date modifyDate;
	
   

	private String supperDeptName;

	@OneToOne(optional = true)
	@JoinColumn(name="supperDeptId",referencedColumnName="deptId")
	private Department supperDeptId;
	public Department(String deptId, String deptName, Department supperDeptId, String supperDeptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.supperDeptId = supperDeptId;
		this.supperDeptName = supperDeptName;
	}


	public Department(Department supperDeptId) {
		super();
		this.supperDeptId = supperDeptId;
	}


	public Department(String deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	public String getSupperDeptName() {
		return supperDeptName;
	}
	public Department getSupperDeptId() {
		return supperDeptId;
	}
	public void setSupperDeptId(Department supperDeptId) {
		this.supperDeptId = supperDeptId;
	}
	public void setSupperDeptName(String supperDeptName) {
		this.supperDeptName = supperDeptName;
	}



	public Department() {
		
	}
    public Department(String deptId) {
		this.deptId = deptId;
	}


	public String getDeptId() {
		return deptId;
	}



	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}





	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
		return modifyDate;
	}

	public void setModeifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
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
