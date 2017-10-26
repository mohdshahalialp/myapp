package com.slokam1.FirstProject.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="studentlogin")
public class StudentPojo {
	@Id
	@GeneratedValue
	private Integer id;
	//@Email
	@Pattern(regexp="^[A-Z][a-z]{8,20}[0-9]{3,6}@[A-Z a-z]{5,8}\\.[a-z]{3,5}$")
	@NotBlank			//this annotation for validation while saving the record,not blank means 
	private String name;//not null(null),not empty("  ") and not blank("").
	private int age;
	@Length(max=10)
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]$")
	private String qual;
	private long phone;
	
	public StudentPojo(String name,int age,String qual,long phone)
	{
		this.name=name;
		this.age=age;
		this.qual=qual;
		this.phone=phone;
	}
	
	public StudentPojo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
