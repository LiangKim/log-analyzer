package com.zjipst.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DriverController {

	public DriverController() {
		// TODO Auto-generated constructor stub
		System.out.println("goood");
	}
	
	@RequestMapping(value="/driver")
	public String where2GO(){
		return "driver";
	}
}
