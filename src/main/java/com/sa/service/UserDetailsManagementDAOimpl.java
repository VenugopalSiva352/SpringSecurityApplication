package com.sa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.sa.DTO.MyappUser;
import com.sa.DTO.Users;
import com.sa.exception.UserNotSavedException;
@Service
public class UserDetailsManagementDAOimpl implements UserDetailsManager{

	
	JdbcTemplate jdbcTemplate;
	
	PasswordEncoder pse;
	
	@Autowired
	public UserDetailsManagementDAOimpl( JdbcTemplate jdbcTemplate,PasswordEncoder pse) {
       this.jdbcTemplate=jdbcTemplate;
		this.pse=pse;
    }
	
	


	//username, password, email
	//id, username, role
	
	final String userNameQuery = "SELECT customUsers.username, customUsers.password, customUsers.email, customRoles.role AS role "+
            "FROM customUsers "+
            "JOIN customRoles ON customUsers.username = customRoles.username WHERE customUsers.username = ?";

	
	final String createUserSql="INSERT INTO customUsers (username, password, email) \n"
			+ "VALUES (?, ?, ?)";

	final String createRoleSql="insert into customRoles (username, role) values (?,?)";

	final String selectSql="";


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 List<Users> query = jdbcTemplate.query(userNameQuery,new BeanPropertyRowMapper<>(Users.class),username);
		 if(query.size() == 0) {
			 throw new RuntimeException("User not found");
		 }
		 System.out.println(query);
		 List<GrantedAuthority> role= new ArrayList<>();
		 
		 System.out.println(query.get(0).getRole());
		 for(Users user: query) {
			 System.out.println(user.getRole());
			 role.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
			 
		 }
			
			
	    System.out.println(query.get(0).getEmail());
		UserDetails userdetails = User.withUsername(query.get(0).getUsername()).password(query.get(0).getPassword()).roles(query.get(0).getRole()).build();
		UserDetails ud= new MyappUser(query.get(0).getUsername(), query.get(0).getPassword(),role, query.get(0).getEmail());
		return ud;
	}






	@Override
	public void createUser( UserDetails user) {
		MyappUser custUser= (MyappUser) user;
		List<GrantedAuthority> authorities = new ArrayList<>(custUser.getAuthorities());
		 String auth = authorities.get(0).toString();
		 if (auth.startsWith("ROLE_")) {
		        auth = auth.substring(5);
		    }
		 System.out.println("Autorities: "+auth);
		 
		 
		
		int updateUser = jdbcTemplate.update(createUserSql,user.getUsername(),user.getPassword(),custUser.getEmail());
		int updateRole = jdbcTemplate.update(createRoleSql,user.getUsername(),auth);
		
		if(updateUser==0 || updateRole==0) {
			throw new UserNotSavedException("user is not saved");
		}
		System.out.println("user saved succesfully with default role");
		
		
	}






	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
