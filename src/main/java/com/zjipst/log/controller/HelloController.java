package com.zjipst.log.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class HelloController {
	@RequestMapping(method=RequestMethod.GET)
	public String printHello(ModelMap model){
		model.addAttribute("message", "hello, springMVC!");
		return "hello";
	}
}
