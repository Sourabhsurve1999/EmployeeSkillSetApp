package com.EmployeeSkillSetApp.service;
import com.EmployeeSkillSetApp.model.Employee;
import com.EmployeeSkillSetApp.model.EmployeeModel;

public interface EmployeeService {
	
	//create or save
	
	Employee createEmployee(EmployeeModel employeeModel);
	
	//getby empId
	
	Employee getByempId(String empId);
	
	
	//update
	
	Employee updateEmployee(Employee employee,long id);

}
