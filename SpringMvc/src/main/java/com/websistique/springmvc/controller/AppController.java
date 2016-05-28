package com.websistique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websistique.springmvc.model.Employee;
import com.websistique.springmvc.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String emplyeeList (ModelMap model){
		List<Employee> employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allEmployees";
	}
	

}
