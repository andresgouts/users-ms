package com.example.usersms.controller;

import com.example.usersms.dto.UserInputDto;
import com.example.usersms.dto.UserOutputDto;
import com.example.usersms.exception.RestExceptionHandler;
import com.example.usersms.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(RestExceptionHandler.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUser_whenValidUser_shouldReturnCreated() throws Exception {
        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setEmail("test@test.com");
        userInputDto.setName("name");
        userInputDto.setLastname("lastname");
        userInputDto.setUsername("username");
        UserOutputDto createdUser = new UserOutputDto(1L,"test@test.com", "name", "lastname", "username");

        when(userService.createUser(any(UserInputDto.class))).thenReturn(createdUser);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userInputDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void createUser_whenInvalidUser_shouldReturnBadRequest() throws Exception {
        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setEmail("");
        userInputDto.setName("");
        userInputDto.setLastname("");
        userInputDto.setUsername("");

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userInputDto)))
                .andExpect(status().isBadRequest());
    }
}
