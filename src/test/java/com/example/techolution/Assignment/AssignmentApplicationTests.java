package com.example.techolution.Assignment;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testUnauthenticatedAccess() throws Exception {
		mockMvc.perform(get("/user/all"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	@WithMockUser(username = "Surya", password = "Kumar",roles = "ADMIN")
	public void testAuthenticatedAccess() throws Exception {
		mockMvc.perform(get("/user/all"))
				.andExpect(status().isOk());
	}


}
