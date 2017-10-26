package com.slokam1.FirstProject.service;

import java.util.List;

import com.slokam1.FirstProject.exception.DuplicateNameException;
import com.slokam1.FirstProject.pojo.StudentPojo;

public interface IStudentService {
	
	public StudentPojo getStudentById(Integer id);
	
	public List<StudentPojo> getAllStudents();
	
	public void saveStudent(StudentPojo pojo) throws DuplicateNameException;
	
	public void saveStudents(List<StudentPojo> pojos);
	
	public void deletee(StudentPojo pojo);
	

}
