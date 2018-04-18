package com.bigearblessed.smartv.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.pojos.DepartmentShow;
import com.bigearblessed.smartv.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public void save(Department department) {
		departmentRepository.save(department);
	}
	
	public void delete(Department department) {
		departmentRepository.delete(department);
	}

	public Optional<Department> findByDeptId(String deptId) {
		return departmentRepository.findById(deptId);
		
	}

//	public List<Department> getDeptBySupperDeptId(String id) {
//		Optional<Department> optional =  departmentRepository.findById(id);
//		return departmentRepository.findByParent(optional.get());
//	}
	
	/*
	 * 获取所有部门
	 */
	public List<Department> getAllDept(){	
		return departmentRepository.findAll();
	}
	/*
	 * 更新部门
	 */
	public int updateDept(DepartmentShow department,String deptIdo) {
		return departmentRepository.updateDept(department.getSupperDeptName(),new Date(),department.getDeptId(),department.getDeptName(),new Department(department.getSupperDeptId()),deptIdo);
	}
   /*
    * 删除部门	
    */
	 public void deleteDeptByDeptId(String deptid) {
		  departmentRepository.deleteById(deptid);
	 }
}
