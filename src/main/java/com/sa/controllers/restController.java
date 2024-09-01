package com.sa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
	@GetMapping("/create")
	public String createCourrse() {
		return "course created";
	}
	@GetMapping("/update")
	public String updateCourrse() {
		return "course updated";
	}
	@GetMapping("/view")
	public String viewCourrse() {
		return "you can view the created course";
	}
	@GetMapping("/delete")
	public String deleteCourrse() {
		return "delete course";
	}
}
