package com.sa.DTO;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyappUser extends User{
	

	private String email;

	private static final long serialVersionUID = 1L;

	
	public MyappUser(String username, String password, Collection<? extends GrantedAuthority> authorities,String email) {
		super(username, password, authorities);
		this.email=email;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
