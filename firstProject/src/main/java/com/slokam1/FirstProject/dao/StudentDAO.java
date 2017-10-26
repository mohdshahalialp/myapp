package com.slokam1.FirstProject.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam1.FirstProject.pojo.StudentPojo;

@Repository
public interface StudentDAO extends JpaRepository<StudentPojo, Integer> {
	
	Logger logger = Logger.getLogger(StudentDAO.class);
	

	public List<StudentPojo> findByName(String name);

}
