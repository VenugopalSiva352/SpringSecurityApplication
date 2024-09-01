package com.sa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class firstController {
	
	
	
	@GetMapping("/hi")
	@ResponseBody
	public String sayHi() {
		return "Hi.... Hello";
	}
	
	
}
