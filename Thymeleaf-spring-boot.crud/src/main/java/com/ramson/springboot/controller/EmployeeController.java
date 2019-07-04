package com.ramson.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ramson.springboot.entity.Employee;



@Controller
@RequestMapping("/employees")
public class EmployeeController {

	//load employee data
	private List<Employee>theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		//create employees
		Employee emp1 = new Employee(1, "Ramson", "Mdee", "ramson@codx.com");
		Employee emp2 = new Employee(2, "Feruz", "Yasin", "feruzi@codx.com");
		Employee emp3 = new Employee(3, "Abdul", "Aziz", "abdul@codx.com");
		Employee emp4 = new Employee(4, "Faith", "Owen", "faith@codx.com");
		
		//create the list
		theEmployees = new ArrayList<Employee>();
		
		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
}
