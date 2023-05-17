package com.EmployeeSkillSetApp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.EmployeeSkillSetApp.model.Employee;
import com.EmployeeSkillSetApp.model.EmployeeModel;
import com.EmployeeSkillSetApp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private PasswordEncoder encoder;

//	@Override
//	public Employee createEmployee(Employee employee) {
//		
//		return repository.save(employee);
//	}

	public Employee getByempId(String empId) {

		return repository.findByEmpId(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = repository.findById(id).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setGrade(employee.getGrade());
		
		  existingEmployee.setPrimarySkill(employee.getPrimarySkill());
		  existingEmployee.setSecondarySkill(employee.getPrimarySkill());
		  existingEmployee.setOtherSkills1(employee.getOtherSkills1());
		  existingEmployee.setOtherSkills2(employee.getOtherSkills2());
		  existingEmployee.setOtherSkills3(employee.getOtherSkills3());
		 
		return repository.save(existingEmployee);
	}

	@Override
	public Employee createEmployee(EmployeeModel employeeModel) {
		Employee newEmployee = new Employee();
		/*
		 * newEmployee.setEmail(employeeModel.getEmail());
		 * newEmployee.setEmpId(employeeModel.getEmpId());
		 * newEmployee.setFirstName(employeeModel.getFirstName());
		 * newEmployee.setGrade(employeeModel.getGrade());
		 * newEmployee.setLastName(employeeModel.getLastName());
		 * newEmployee.setOtherSkills1(employeeModel.getOtherSkills1());
		 * newEmployee.setOtherSkills2(employeeModel.getOtherSkills2());
		 * newEmployee.setOtherSkills3(employeeModel.getOtherSkills3());
		 * newEmployee.setPrimarySkill(employeeModel.getPrimarySkill());
		 * System.out.println(employeeModel.getSecondarySkill());
		 * newEmployee.setSecondarySkill(employeeModel.getSecondarySkill());
		 */
		
		BeanUtils.copyProperties(employeeModel, newEmployee);
		newEmployee.setPassword(encoder.encode(employeeModel.getPassword()));
		return repository.save(newEmployee);
	}

}
