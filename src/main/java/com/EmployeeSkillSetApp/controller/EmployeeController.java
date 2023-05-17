package com.EmployeeSkillSetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeSkillSetApp.model.Employee;
import com.EmployeeSkillSetApp.model.EmployeeModel;
import com.EmployeeSkillSetApp.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp_Details/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
//	
//	@PostMapping("/save")
//	public Employee createEmployee(@RequestBody EmployeeModel employeeModel) {
//		return service.createEmployee(employeeModel);
//	}



	@GetMapping("/get/{empId}")
	public Employee getByempId(@PathVariable("empId") String empId) {
		return service.getByempId(empId);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		return service.updateEmployee(employee, id);
	}

}
