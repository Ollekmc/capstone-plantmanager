package de.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.backend.model.User;
import de.backend.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldAddUser() throws Exception {
        MvcResult response = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                        """
{
"name" : "UserTestName"
}
"""
                ))
                .andExpect(status().isOk())
                .andReturn();

        String content = response.getResponse().getContentAsString();
        User result = objectMapper.readValue(content, User.class);
        User expected = new User(result.getId(),result.getName(),result.getPlants());

        assertEquals(result,expected);
    }
    @Test
    @DirtiesContext
    void shouldReturnUserList () throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andReturn();
    }
}