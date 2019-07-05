package com.ramson.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	//add mapping for "/update employee 
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
			
			// get the employee from the service
			Employee theEmployee = employeeService.findById(theId);
			
			//set employee as a model attribute to pre-populate the form
			theModel.addAttribute("employee", theEmployee);
			
			//send over to our employee form
			return "employees/employee-form";
			
		}
	
	//add mapping for "/save employee on the DB
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		//save the employee
		employeeService.save(theEmployee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
}
