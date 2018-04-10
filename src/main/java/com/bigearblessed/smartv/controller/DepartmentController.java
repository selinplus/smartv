package com.bigearblessed.smartv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping(value="/api/dept/{id}")
	public Department getDept(@PathVariable("id") String id) {
		return departmentService.getDeptById(id);
	}
	@GetMapping(value="/api/dept/children/{id}")
	public List<Department> getDeptChildren(@PathVariable("id") String id) {
		return departmentService.getDeptByParentId(id);
	}
	@PostMapping(value="dept/save")
	public String save(@RequestBody Department dept) {
		try {
			departmentService.save(dept);
			return "/dept/save";
		} catch (Exception e) {
			return "/dept/exception";
		}
		
	}
}
