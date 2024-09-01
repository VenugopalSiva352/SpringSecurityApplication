package com.sa.DTO;

public class RoleDto {

	private String username;
	private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "RoleDto [username=" + username + ", role=" + role + "]";
	}
	public RoleDto(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}
	
	
}
