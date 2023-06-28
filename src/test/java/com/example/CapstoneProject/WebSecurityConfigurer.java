//package com.example.CapstoneProject;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.example.CapstoneProject.entities.User;
//
//@Configuration
//public class WebSecurityConfigurer {
//
//	@Bean
//	InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
//		UserDetails user = User.withUsername("spring").password(passwordEncoder.encode("secret")).roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeRequests().requestMatchers("/private/**").hasRole("USER").requestMatchers("/public/**")
//				.permitAll().and().httpBasic();
//		return http.build();
//	}
//
//	@Bean
//	BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}