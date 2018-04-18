package com.bigearblessed.smartv.controller;


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigearblessed.smartv.entities.Department;

import com.bigearblessed.smartv.pojos.DepartmentShow;
import com.bigearblessed.smartv.pojos.UpdateDepart;
import com.bigearblessed.smartv.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping(value="/main/departments/getDeptByDeptId")
	public Department getDept(String id) {
	    Optional<Department> department = departmentService.findByDeptId(id);
		return department.get();
	}
	
//	@GetMapping(value="/main/dept/children/{id}")
//	public List<Department> getDeptChildren(@PathVariable("id") String id) {
//		return departmentService.getDeptBySupperDeptId(id);
//	}
	/*
	 * 增加部门
	 */
	
	@PostMapping(value="/main/departments/addDepartment")
	public Map<String, String> save(@RequestBody Department dept) {
		Map<String, String> map = new HashMap<String,String>();
		try { 
			Date date = new Date();
			dept.setCreatedDate(date);
			dept.setModifyDate(date);
			departmentService.save(dept);
			map.put("addDept", "true");
			map.put("msg", "部门添加成功！！！");
			return map;
		} catch (Exception e) {
			System.out.println(e);
			map.put("addDept", "false");
			map.put("msg", "部门添加失败！！！");
			return map;
		}
	}
	/*
	 * 获取部门
	 */
	@GetMapping(value = "/main/departments/getAllDept")
	public Map<String,List<DepartmentShow>> getAllDept(){

		List<DepartmentShow> list = new ArrayList<DepartmentShow>();
	
		Map<String, List<DepartmentShow>> map = new HashMap<String,List<DepartmentShow>>();
		List<Department> page = departmentService.getAllDept();
 		List<Department> depart = departmentService.getAllDept();
 		for(int i=0;i<depart.size();i++) {
 		
 			list.add(new DepartmentShow(depart.get(i).getDeptName(),depart.get(i).getSupperDeptName(),depart.get(i).getDeptId(),depart.get(i).getSupperDeptId().getDeptId()));
 
 		}
 		map.put("depts",list);
		return map;
	}
	/*
	 * 编辑部门
	 */
	@PostMapping(value = "/main/departments/updateDept")

	public Map<String, String> updateDept(@RequestBody UpdateDepart depart) {
		Map<String, String> map = new HashMap<String,String>();
		try {
			DepartmentShow originalDept = depart.getOriginalDept();
			DepartmentShow modifiedDept = depart.getModifiedDept();
			int i = departmentService.updateDept(modifiedDept,originalDept.getDeptId());
			if(i==1) {
				map.put("updateDept", "true");
				map.put("msg", "部门修改成功！！！");
				return map;
			}
			map.put("updateDept", "false");
			map.put("msg", "部门修改失败！！！");
			return map;

		}catch (Exception e) {
			System.out.println(e);
			map.put("updateDept", "false");
			map.put("msg", "部门修改失败！！！");
			return map;
		}
	}
	/*
	 * 删除部门
	 */
	@PostMapping(value = "/main/departments/deleteDept")
	public Map<String, String> deleteDept(@RequestBody DepartmentShow depart) {
		Map<String, String> map = new HashMap<String,String>();
		try {
			departmentService.deleteDeptByDeptId(depart.getDeptId());
			map.put("deleteDept", "true");
			map.put("msg", "部门删除成功！！！");
			return map;
		}catch(Exception e){
			System.out.println(e);
			map.put("deleteDept", "false");
			map.put("msg", "部门删除失败！！！");
			return map;
		}
	
	}
}
