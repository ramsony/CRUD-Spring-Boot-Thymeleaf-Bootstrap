package com.ramson.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ramson.springboot.entity.Employee;
import com.ramson.springboot.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//constructor injections
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
		
	}

	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		//get all the employees from the database
		List<Employee> theEmployees = employeeService.findAll();
		
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	
	//add mapping for "/add employee
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create a model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	
}
