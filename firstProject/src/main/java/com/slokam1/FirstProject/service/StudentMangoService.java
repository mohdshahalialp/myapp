package com.slokam1.FirstProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam1.FirstProject.dao.StudentDAO;
import com.slokam1.FirstProject.exception.DuplicateNameException;
import com.slokam1.FirstProject.pojo.StudentPojo;

@Service
public class StudentMangoService implements IStudentService {
	
	@Autowired
	private StudentDAO studentDAO;
	
	public StudentPojo getStudentById(Integer id)
	{
		return null;
	}
	
	
	public List<StudentPojo> getAllStudents()
	{
		return null;
	}
	
	
	public void saveStudent(StudentPojo pojo) throws DuplicateNameException
	{
		return;
	}
	
	
	public void saveStudents(List<StudentPojo> pojos)
	{
		return;
	
	}	
	
	public void deletee(StudentPojo pojo)
	{
		return ;
	}

}
