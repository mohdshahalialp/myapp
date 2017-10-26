package com.slokam1.FirstProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam1.FirstProject.pojo.StudentPojo;

@RestController
public class OurController {

	
	@RequestMapping("getData")
	public String getData()
	{
		return "hello this is rahul Dravid";
	}
	
	@RequestMapping("getStringArrayData")
	public String[] getStringArrayData()
	{
		String[] str = {"abc","def","ghi","jkl"};
		return str;
	}
	
	@RequestMapping("getStudentData")
	public StudentPojo getStudentData()
	{
		StudentPojo student = new StudentPojo("sehwag", 37, "DEGREE", 9898654l);
		return student;
	}
	
	@RequestMapping("getListData")
	public List<StudentPojo> getListData()
	{
		StudentPojo std1 = new StudentPojo("sachin", 44, "SSC",6546556l);
		StudentPojo std2 = new StudentPojo("dravid", 34, "DEGREE",6546576l);
		StudentPojo std3 = new StudentPojo("yuvraj", 36, "INTER",9876556l);
		StudentPojo std4 = new StudentPojo("laxman", 43, "BTECH",8846556l);
		StudentPojo std5 = new StudentPojo("zaheerkhan", 36, "DEGREE",4566546l);
		
		List<StudentPojo> list = new ArrayList<>();
		list.add(std1);
		list.add(std2);
		list.add(std3);
		list.add(std4);
		list.add(std5);
		
		return list;
		
	}
	
	@RequestMapping("getMapData")
	public Map<Integer, StudentPojo> getMapData()
	{
		StudentPojo std1 = new StudentPojo("sachin", 44, "SSC",6546556l);
		StudentPojo std2 = new StudentPojo("dravid", 34, "DEGREE",6546576l);
		StudentPojo std3 = new StudentPojo("yuvraj", 36, "INTER",9876556l);
		StudentPojo std4 = new StudentPojo("laxman", 43, "BTECH",8846556l);
		StudentPojo std5 = new StudentPojo("zaheerkhan", 36, "DEGREE",4566546l);
		
		Map<Integer, StudentPojo> map = new HashMap<>();
		map.put(1, std1);
		map.put(2, std2);
		map.put(3, std3);
		map.put(4, std4);
		map.put(5, std5);
		
		return map;
	}
}
