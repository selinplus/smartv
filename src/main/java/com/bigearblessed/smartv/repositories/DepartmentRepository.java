package com.bigearblessed.smartv.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigearblessed.smartv.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
	List<Department> findByParent(Department department);
}
