package com.bigearblessed.smartv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigearblessed.smartv.entities.Department;
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

	public Department getDeptById(String id) {
		return departmentRepository.getOne(id);
	}

	public List<Department> getDeptByParentId(String id) {
		Optional<Department> optional =  departmentRepository.findById(id);
		return departmentRepository.findByParent(optional.get());
	}
}
