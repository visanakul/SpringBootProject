package com.vishal.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	public AppController(){
		System.out.println("*** AppController init ***");
	}
	@GetMapping(value = "/welcome")
	public String greet() {
		return "<h1>Welcome to Spring boot MVC</h1>";
	}
}
