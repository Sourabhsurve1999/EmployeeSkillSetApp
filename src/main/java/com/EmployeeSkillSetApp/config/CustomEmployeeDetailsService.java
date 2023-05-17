package com.EmployeeSkillSetApp.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.EmployeeSkillSetApp.model.Employee;
import com.EmployeeSkillSetApp.repository.EmployeeRepository;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository repository;
//	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee existingEmployee=repository.findByEmail(email).orElseThrow();
		
		UserDetails user = new org.springframework.security.core.userdetails.User(existingEmployee.getEmail(),
				existingEmployee.getPassword(), new ArrayList<>());
		return user;
		
		
	
	}

}
