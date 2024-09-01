package com.sa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sa.DTO.MyappUser;
import com.sa.DTO.UserDTO;
import com.sa.service.UserDetailsManagementDAOimpl;

@Controller
public class registrationController {
	
	
	private PasswordEncoder pse;
	
	private UserDetailsManagementDAOimpl udm;
	
	@Autowired
	public registrationController(PasswordEncoder pse, UserDetailsManagementDAOimpl udm) {
	    this.pse = pse;
	    this.udm = udm;
	    
	}
	
	@GetMapping("/reg")
	public String regPage(@ModelAttribute("user")UserDTO user) {
		return "registerr";
	}
	
	
	
	@ResponseBody
	@PostMapping("/processRegistration")
	public String processReg(@ModelAttribute("user")UserDTO user) {
		
		
		GrantedAuthority authorities = new SimpleGrantedAuthority("user");
		List<GrantedAuthority> roles= new ArrayList<>();
		roles.add(authorities);
		
		MyappUser cuser= new MyappUser(user.getUsername(), pse.encode(user.getPassword()), roles, user.getEmail());
		
		udm.createUser(cuser);
		
		
		return "registered successfully";
	}
	
	@RequestMapping(value = {"/adminReg"},method = RequestMethod.GET)
	public String regAdminPage(@ModelAttribute("user")UserDTO user) {
		return "adminreg";
	}
	
	@ResponseBody
	@PostMapping("/processAdminRegistration")
	public String processAdminReg(@ModelAttribute("user")UserDTO user) {
		
		UserDetails appUser = User.withUsername(user.getUsername().toLowerCase()).roles("user","admin").password(pse.encode(user.getPassword().toLowerCase())).build();
		udm.createUser(appUser);
		
		
		return "Admin registered successfully with user and admin roles.";
	}
	@ResponseBody
	@GetMapping("/bye")
	public String byePage() {
		return "Byeeee";
	}
	@ResponseBody
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "You are not authenticated or you may not had proper access";
	}
	
}
