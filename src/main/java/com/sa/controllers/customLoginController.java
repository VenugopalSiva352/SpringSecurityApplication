package com.sa.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class customLoginController {
	
	@GetMapping("/custom-login")
	public String loginPage() {
		return "custom-login";
	}
	
	
	
	
	
	@GetMapping("/home")
	public String homePage(Model model,Principal principle,Authentication authentcation) {
		
		System.out.println(authentcation);
		System.out.println("*********************");
		System.err.println("principal details: "+principle);
		
		
		
		model.addAttribute("username", principle.getName());
		model.addAttribute("authorities", authentcation.getAuthorities());
		return "home";
	}
	
}
