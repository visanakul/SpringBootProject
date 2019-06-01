package com.vishal.web.model;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	@NotEmpty
	@Size(min = 3,max = 40)
	private String fname;
	@NotEmpty
	@Size(min = 3,max = 40)
	private String lname;
	@NotEmpty
	@Email
	@Size(min = 6,max = 40)
	private String email;
	@NotNull
	@Digits(integer = 10,fraction = 0,message = "10 Digit mobile number")
	private Long mobile;
	@NotEmpty
	@Size(min = 6,max = 10)
	private String pass;
	
	@NotEmpty
	@Size(min = 6,max = 10)
	private String cpass;
	@NotEmpty
	private String gen;
	private String role;
	@NotNull
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dob;
	
}
/*
"fname" : {
                required: true,
                minlength: 3,
                maxlength: 40
            },
			"lname" : {
                required: true,
                minlength: 3,
                maxlength: 40
            },
			"email" : {
                required: true,
                email: true,
                minlength: 6,
                maxlength: 40
            },
			"pass" : {
                required: true,
                minlength: 6,
                maxlength: 10
            },
            "cpass" : {
                required: true,
                equalTo: "#pass"
            },
			"gen" : {
                required: true
            },
			"mobile" : {
                required: true,
                number:true,
                minlength: 10,
                maxlength: 10
            },
			"role":{
                required: true
            },
            "dob":{
                required: true
            }
*/