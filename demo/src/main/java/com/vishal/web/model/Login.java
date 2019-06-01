package com.vishal.web.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Login {
	@NotEmpty
	@Email
	@Size(min = 6,max = 40)
	private String email;
	@NotEmpty
	@Size(min = 6,max = 10)
	private String pass;
}
