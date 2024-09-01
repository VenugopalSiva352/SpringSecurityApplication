package com.sa.DTO;

public class UserDTO {
//this class is used to get the data from users table only.
	private String username;
	private String password;
	private String email;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	
	
	public UserDTO(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
