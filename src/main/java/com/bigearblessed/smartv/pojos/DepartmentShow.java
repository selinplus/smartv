package com.bigearblessed.smartv.pojos;

public class DepartmentShow {
  
	private String deptName;
	private String supperDeptName;
	private String deptId;
	private String supperDeptId;
	public DepartmentShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentShow(String deptName, String supperDeptName, String deptId, String supperDeptId) {
		super();
		this.deptName = deptName;
		this.supperDeptName = supperDeptName;
		this.deptId = deptId;
		this.supperDeptId = supperDeptId;
	}
	public DepartmentShow(String deptName, String supperDeptName, String deptId) {
		super();
		this.deptName = deptName;
		this.supperDeptName = supperDeptName;
		this.deptId = deptId;
	}
	public DepartmentShow(String deptName, String deptId) {
		super();
		this.deptName = deptName;
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getSupperDeptName() {
		return supperDeptName;
	}
	public void setSupperDeptName(String supperDeptName) {
		this.supperDeptName = supperDeptName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getSupperDeptId() {
		return supperDeptId;
	}
	public void setSupperDeptId(String supperDeptId) {
		this.supperDeptId = supperDeptId;
	}
	
	
}	
