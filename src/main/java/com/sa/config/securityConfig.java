package com.sa.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.mysql.cj.jdbc.Driver;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	
	
		

	
	@Bean
	public DataSource datasource() throws SQLException {
		
		//"com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/", "root", "root@root"
		Driver d= new Driver();
	SimpleDriverDataSource ds=new SimpleDriverDataSource(d, "jdbc:mysql://localhost:3306/Security", "root", "root@root");
	
	return ds;
}



	@Bean
    public SecurityFilterChain setUpFilterChain(@Autowired HttpSecurity httpSecurity) throws Exception {
		
        httpSecurity
            .authorizeHttpRequests(authreq -> { 
            	 authreq.requestMatchers("/reg", "/bye", "/processRegistration", "/WEB-INF/views/*", 
            					    "/processAdminRegistration", "/adminReg", "/custom-login", "/custom-logout").permitAll()
          				.requestMatchers("/hi").hasAnyRole("user","admin","editor")
          				.requestMatchers("/create").hasRole("admin")
          				.requestMatchers("/view").hasAnyRole("user","admin","editor")
          				.requestMatchers("/update").hasAnyRole("admin","editor")
          				.requestMatchers("/delete").hasRole("admin")
            			.anyRequest().authenticated();	 } );
        
        //hasAuthority checks for only the given string
        //hasRole checks for given string prefixed with ROLE_( ROLE_admin).
        httpSecurity.formLogin(customiser ->
		        							customiser.loginPage("/custom-login").defaultSuccessUrl("/home")
		        									  .loginProcessingUrl("/processLogin"));
        
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.logout(customiser ->
										customiser.logoutUrl("/custom-logout"));
        
        httpSecurity.exceptionHandling(exception -> 
        											exception.accessDeniedPage("/access-denied"));											

        return httpSecurity.build();
    }
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public JdbcTemplate getTemplate() throws SQLException {
		return new JdbcTemplate(datasource());
	}
	
	
	public JdbcUserDetailsManager userdetailsmanager() throws SQLException {
		
		return new JdbcUserDetailsManager(datasource());
	}
	
//	@Bean
//	public InMemoryUserDetailsManager setupUser() {
//		
//		UserDetails build = User
//				.withUsername("Raju")
//				.password(passwordEncoder().encode("raju"))
//				.roles("user","admin")
//				.build();
//		InMemoryUserDetailsManager udm= new InMemoryUserDetailsManager(build);
//		return udm;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	public  UserDetailsManager setUpUser() {
//	ArrayList<GrantedAuthority> role1= new ArrayList();
//	GrantedAuthority auth1= new SimpleGrantedAuthority("user");
//	GrantedAuthority auth2= new SimpleGrantedAuthority("admin");
//	GrantedAuthority auth3= new SimpleGrantedAuthority("customer");
//	role1.add(auth1);
//	role1.add(auth2);
//	role1.add(auth3);
//	UserDetails user1= new User("Gopal", "gopal", role1);
//	UserDetailsManager usermanager = new InMemoryUserDetailsManager();
//	usermanager.createUser(user1);
//	 return usermanager;
//	}		
//	@Bean
//	public PasswordEncoder encoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
}
