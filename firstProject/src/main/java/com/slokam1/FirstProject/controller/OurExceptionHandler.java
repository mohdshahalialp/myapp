package com.slokam1.FirstProject.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.slokam1.FirstProject.exception.DuplicateNameException;


@ControllerAdvice
public class OurExceptionHandler {
	
	Logger logger = Logger.getLogger(OurExceptionHandler.class);
	
	@ExceptionHandler(DuplicateNameException.class)
	public ResponseEntity handleException()
	{
		//System.out.println("exception handler::::DuplicateNameException");
		logger.debug("exception handler::::DuplicateNameException");
		ResponseEntity	responseEntity2 = new ResponseEntity(HttpStatus.CONFLICT);
		return responseEntity2;	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handle2Exception()
	{
		//System.out.println("exception handler::::Exception");
		logger.debug("exception handler::::Exception");
		ResponseEntity	responseEntity2 = new ResponseEntity(HttpStatus.CONFLICT);
		return responseEntity2;	
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity handle3Exception()
	{
		//System.out.println("exception handler::::IOException");
		logger.debug("exception handler::::IOException");
		ResponseEntity	responseEntity2 = new ResponseEntity(HttpStatus.CONFLICT);
		return responseEntity2;	
	}
}
