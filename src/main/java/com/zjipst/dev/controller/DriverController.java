package com.zjipst.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DriverController {
	@RequestMapping(value="/driver")
	public String where2GO(){
		return "driver";
	}
}
