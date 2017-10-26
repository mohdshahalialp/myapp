package com.slokam1.FirstProject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.slokam1.FirstProject.StringUtil.Stringutil;
import com.slokam1.FirstProject.exception.DuplicateNameException;
import com.slokam1.FirstProject.pojo.StudentPojo;
import com.slokam1.FirstProject.service.IStudentService;
import com.slokam1.FirstProject.service.StudentService;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

@RestController
@RequestMapping("StudentPojo")
public class StudentController {

	Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	//@Qualifier("studentService")
	@Qualifier("ss")
	private IStudentService studentService;
	
	@Autowired
	private Stringutil stringUtil;
	
	
	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<StudentPojo>  getStudentById(@PathVariable("id") Integer sid) throws IOException
	{
		logger.debug("method starting::getstudentById");
		
		//if(true)
			//throw new IOException();
		
		ResponseEntity<StudentPojo> responseEntity;
		
		StudentPojo std = studentService.getStudentById(sid);
		if(std!=null)
		{
			logger.debug("student Data is available for id::"+sid);
			responseEntity=new ResponseEntity<StudentPojo>(std,HttpStatus.OK);
		}
		else
		{
			logger.debug("student Data is not available for id::"+sid);
			responseEntity=new ResponseEntity<StudentPojo>(HttpStatus.NOT_FOUND);
		}
		
		logger.debug("method ending::getstudentById");
		
		return responseEntity;
	
		//return studentService.getStudentById(sid);

	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<StudentPojo> getAllStudents() throws Exception
	{
		logger.debug("getAllstudents");
		
		stringUtil.m1();
		//if(true)
			//throw new Exception();
		return studentService.getAllStudents();
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity saveStudent(@Validated @RequestBody StudentPojo pojo, BindingResult result)
							throws DuplicateNameException
	{
		logger.debug("method starting::saveStudent");
		ResponseEntity responseEntity;
		if(result.hasErrors())
		{
			logger.debug("saveStudent returns errors");
			List<ObjectError> objectError = result.getAllErrors();
			List<String> list = new ArrayList<>();
			
			for (ObjectError objectError2 : objectError) {
				list.add(objectError2.getDefaultMessage());
			}
			responseEntity = new ResponseEntity<>(list,HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
		/*try {
			studentService.saveStudent(pojo);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (DuplicateNameException e) {
			responseEntity = new ResponseEntity(HttpStatus.CONFLICT);
			e.printStackTrace();
		}
		return responseEntity;
		*/
	
		studentService.saveStudent(pojo);
		
		logger.debug("saveStudent does not returns any error....success");
		
		ResponseEntity responseEntity1 = new ResponseEntity(HttpStatus.OK);
		
		logger.debug("method ending::saveStudent");
		
		return responseEntity1;
	
	}
	@RequestMapping(value="/all",method=RequestMethod.POST)
	public void saveStudents(@RequestBody List<StudentPojo> pojos)
	{
		logger.debug("method started::saveStudents");
		
		studentService.saveStudents(pojos);
		
		logger.debug("method ending::saveStudents");
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void deletee(@RequestBody StudentPojo pojo)
	{
		logger.debug("method starting::deletee");
		
		studentService.deletee(pojo);
		
		logger.debug("method ending::deletee");
	}
	
	
}
