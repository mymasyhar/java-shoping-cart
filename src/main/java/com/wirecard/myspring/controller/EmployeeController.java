package com.wirecard.myspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wirecard.myspring.model.Employee;
import com.wirecard.myspring.service.EmployeeService;

@Controller
public class EmployeeController {
	
	EmployeeService service;
	
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listOfEmployee(Model model) {
		model.addAttribute("employeeList", service.listOfEmployees());
		
		return "employee-list";
	}
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listOfProducts(Model model) {
		model.addAttribute("employeeList", service.listOfEmployees());
		return "employee-list";
	}
	
	@RequestMapping(value = "/products/bycode/{code}", method = RequestMethod.GET)
	public String findProduct(@PathVariable("code") String code, Model model) {
		model.addAttribute("employeeList", service.listOfEmployees());
		return "employee-list";
	}
	
	
	@GetMapping("/employee/form")
	public String showNewEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		
		return "employee-form";
	}
	
	@RequestMapping(value="/employee/add", method = RequestMethod.POST)
	public String addNewEmployee(@ModelAttribute("employee") Employee employee) {
		employee.setId(service.nextId());
		
		service.addEmployee(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employee/view/{id}", method = RequestMethod.GET)
	public String viewEmployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", service.findEmployeeById(id));
		return "employee-view";
	}
}
