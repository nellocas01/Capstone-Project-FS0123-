package com.example.CapstoneProject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void successfulLoginTest() throws Exception {
		mockMvc.perform(formLogin().user("username").password("password")).andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/dashboard")).andExpect(authenticated().withUsername("username"));
	}

	@Test
	public void failedLoginTest() throws Exception {
		mockMvc.perform(formLogin().user("invalidUsername").password("invalidPassword"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/login?error"))
				.andExpect(unauthenticated());
	}

	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(logout()).andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/login?logout"))
				.andExpect(unauthenticated());
	}
}
