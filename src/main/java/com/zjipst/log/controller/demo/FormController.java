package com.zjipst.log.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zjipst.log.model.Student;

/**
 * 测试表单提交
 * @author kim
 */
@Controller
public class FormController {
	
	@ModelAttribute
	private void interceptor(){
		System.out.println("我在controller的所有请求之前执行！");
	}
	
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView student(){
		return new ModelAndView("student", "command", new Student());
	}
	
	@RequestMapping(value="/student/add")
	public String addStudent(Model model){
		return "result";
	}
}
