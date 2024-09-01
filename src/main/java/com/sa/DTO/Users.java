package com.sa.DTO;

public class Users {
//this class helps to get the user table data along with role data from role table using join sql query.
	private String username;
	private String password; 
	private String email;
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Users(String username, String password, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", email=" + email + ", roles=" + role + "]";
	}
	public String getRole() {
	    return role;
	}

	public void setRole(String role) {
	    this.role = role;
	}
	public Users() {
	
	}
	
	
	
	
}
