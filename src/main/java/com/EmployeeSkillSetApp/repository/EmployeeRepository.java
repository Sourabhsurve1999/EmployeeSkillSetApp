package com.EmployeeSkillSetApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeSkillSetApp.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmpId(String empId);

	Optional <Employee >findByEmail(String email);

	boolean existsByEmail(String email);

}
