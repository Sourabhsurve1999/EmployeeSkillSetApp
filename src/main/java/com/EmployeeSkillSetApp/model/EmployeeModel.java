package com.EmployeeSkillSetApp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmployeeModel {

	private Long id;

	@NotBlank
	private String empId;

	@Email
	private String email;

	private String password;

	private String firstName;

	private String lastName;

	private String grade;

	@NotBlank(message = "Primary Skill field is Mandatory")
	private String primarySkill;

	@NotBlank(message = "Secondary Skill is Mandatory")
	private String secondarySkill;

	private String otherSkills1;

	private String otherSkills2;

	private String otherSkills3;

}
