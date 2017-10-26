package com.slokam1.myproject.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.slokam1.FirstProject.StringUtil.Stringutil;

@SpringBootApplication
@EnableJpaRepositories("com.slokam1.Firstproject.dao")
@ComponentScan({"com.slokam1.Firstproject.controller","com.slokam1.Firstproject.service","com.slokam1.FirstProject.StringUtil"})
@EntityScan("com.slokam1.Firstproject.pojo")
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
	
	@Bean
	public Stringutil stringUtil()
	{
		return new Stringutil();	
	}
}
