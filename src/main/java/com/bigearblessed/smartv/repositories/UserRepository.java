package com.bigearblessed.smartv.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bigearblessed.smartv.entities.Department;
import com.bigearblessed.smartv.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,String>,PagingAndSortingRepository<User,String> {
	
	@Query("select u from User u where u.username=?1")
	User findByUsername(String username);
	
//	@Query("select u from user where id=?1 ")
//	User findByMobile(String id); 
	
	/*
	 * update
	 */
	@Modifying@Transactional   
	@Query("update User u set u.deptName=?1,u.phone=?2,u.password=?3,u.username=?4,u.dept=?5 where u.username=?6")
	int updateById	(String deptName,String phone,String password,String username,Department dept,String userO);

	/*
	 * delete
	 */
	@Modifying@Transactional   
	@Query("delete User u where u.username =?1")
	int deleteUsername(String username);
		
	
}
