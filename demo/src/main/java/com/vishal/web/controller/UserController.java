package com.vishal.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vishal.web.model.User;

@Controller
public class UserController {
	public UserController() {
		System.out.println("***::UserController::***");
	}

	@GetMapping("register")
	public String showUserForm(Model model,@ModelAttribute("msg") String msg) {
		model.addAttribute("user", new User());
		model.addAttribute("msg", msg);
		System.out.println("Redirected attribute : "+msg);
		initUserModel(model);
		return "register";
	}
	
	public void initUserModel(Model model) {
		List<String> genders=new ArrayList<>();
		genders.add("Male");
		genders.add("Female");
		model.addAttribute("genders", genders);
		
		List<String> roles=new ArrayList<>();
		roles.add("Admin");
		roles.add("Co-worker");
		model.addAttribute("roles", roles);
	}
	@PostMapping("saveRegInfo")
	public String saveUserInfo(@ModelAttribute User user,RedirectAttributes ra) {
		System.out.println(user);
		//initUserModel(model);
		//model.addAttribute("msg", "Registration Successful...");
		ra.addFlashAttribute("msg", "Registration Successful...");
		return "redirect:/register";
	}
	@GetMapping("login")
	public String showLoginForm(Model model,@ModelAttribute("msg") String msg) {
		model.addAttribute("user", new User());
		return "login";
	}
	@PostMapping("checkLogInfo")
	public String checkLoginInfo(@ModelAttribute User user,RedirectAttributes ra) {
		System.out.println(user);
		//initUserModel(model);
		//model.addAttribute("msg", "Registration Successful...");
		ra.addFlashAttribute("msg", "Login Successful...");
		return "redirect:/login";
	}
}
