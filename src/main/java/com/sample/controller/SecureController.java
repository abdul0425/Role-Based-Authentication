package com.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureController {

//	http://localhost:9090/api/getdisplay
	
	@GetMapping("/getdisplay")
	public String display() 
	{
		return "This is a display method";
	}
	
	
//	http://localhost:9090/api/getmessage
	@GetMapping("/getmessage")
	public String message() 
	{
	return "This is a message method";
	}
	}

