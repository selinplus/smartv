package com.bigearblessed.smartv.repositories;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bigearblessed.smartv.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{
	//List<Department> findByParent(Department department);
	
	@Modifying@Transactional
	@Query("update Department d set d.supperDeptName=?1,d.modifyDate=?2,d.deptId=?3,d.deptName=?4,d.supperDeptId=?5 where d.deptId=?6")
	int updateDept(String supperDeptName,Date modifyDate,String deptIdM,String deptName,Department supperDeptId,String deptIdO);
	
	
}
