package com.slokam1.FirstProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slokam1.FirstProject.dao.StudentDAO;
import com.slokam1.FirstProject.exception.DuplicateNameException;
import com.slokam1.FirstProject.pojo.StudentPojo;


@Service("ss")
public class StudentService  implements IStudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	
	public StudentPojo getStudentById(Integer id)
	{
		return studentDAO.findOne(id);
	}
	
	
	public List<StudentPojo> getAllStudents()
	{
		return studentDAO.findAll();
	}
	
	
	public void saveStudent(StudentPojo pojo) throws DuplicateNameException
	{
		List<StudentPojo> list = studentDAO.findByName(pojo.getName());
		
		if(list.size()>0)
		{
			throw new DuplicateNameException();
		}
		
		studentDAO.save(pojo);
		
	}
	
	
	public void saveStudents(List<StudentPojo> pojos)
	{
		studentDAO.save(pojos);
	
	}	
	
	public void deletee(StudentPojo pojo)
	{
		studentDAO.delete(pojo);
	}

}
