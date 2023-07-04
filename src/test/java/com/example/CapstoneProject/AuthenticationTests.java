package com.example.CapstoneProject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
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
				.andExpect(redirectedUrl("/auth/login")).andExpect(authenticated().withUsername("username"));
	}

	@Test
	public void failedLoginTest() throws Exception {
		mockMvc.perform(formLogin().user("invalidUsername").password("invalidPassword"))
				.andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/auth/login?error"))
				.andExpect(unauthenticated());
	}
}
