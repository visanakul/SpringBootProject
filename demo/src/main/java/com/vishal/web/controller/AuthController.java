package com.vishal.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
	public AuthController() {
		System.out.println("***::AuthController:***");
	}
	@GetMapping("/")
	public String greet(Model model) {
		model.addAttribute("msg", "View and Model from AuthController greet()");
		return "index";
	}
	@GetMapping("/today")
	public @ResponseBody String showDate() {
		//SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a z");//for 12 hr--- hh
		SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a z");//for 24 hr--- HH
		Date today=new Date();
		return "<h3>Today is "+myFormat.format(today)+"</h3>";
	}
}
