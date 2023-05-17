package com.EmployeeSkillSetApp.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	
	@Column(name = "empId")
	private String empId;

	private String email;

	@JsonIgnore
	private String password;

	private String firstName;

	private String lastName;

	private String grade;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "empId", referencedColumnName = "id")
//	private Skill skills;

	private String primarySkill;

	private String SecondarySkill;

	private String otherSkills1;

	private String otherSkills2;

	private String otherSkills3;

}
