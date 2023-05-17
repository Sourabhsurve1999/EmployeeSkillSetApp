package com.EmployeeSkillSetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeSkillSetApp.config.CustomEmployeeDetailsService;
import com.EmployeeSkillSetApp.config.JwtUtils;
import com.EmployeeSkillSetApp.dto.LogInDto;
import com.EmployeeSkillSetApp.model.Employee;
import com.EmployeeSkillSetApp.model.EmployeeModel;
import com.EmployeeSkillSetApp.model.JwtResponse;
import com.EmployeeSkillSetApp.service.EmployeeService;

@RestController
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    CustomEmployeeDetailsService customEmployeeDetailsService;


    @Autowired
    EmployeeService employeeService;
    @Autowired
    private JwtUtils jwtUtils;
    
    

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> Login(@RequestBody LogInDto logInDto) throws Exception{

        authenticate(logInDto.getEmail(),logInDto.getPassword());
        //Generate JWT token
        final UserDetails userDetails= customEmployeeDetailsService.loadUserByUsername(logInDto.getEmail());
        final String token= jwtUtils.generateToken(userDetails);
        return new ResponseEntity<JwtResponse> (new JwtResponse(token),HttpStatus.OK);
    }

    private void authenticate(String email, String password) throws Exception {
        try {
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        }catch (DisabledException e){
            throw new Exception("User Disabled");
        }catch (BadCredentialsException e){
            throw new Exception("Bad Credentials");
        }

    }

//    @PostMapping("/register")
//    public ResponseEntity<Employee> createUser(@RequestBody Employee employee){
//        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
//    }

    
	@PostMapping("/register")
	public Employee createEmployee(@RequestBody EmployeeModel employee) {
		return employeeService.createEmployee(employee);
	}

}
