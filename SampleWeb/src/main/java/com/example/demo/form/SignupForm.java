package com.example.demo.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
	
	@Length(min=8,max=20)
	private String loginId;
	
	@Length(min=8,max=20)
	private String password;

}
