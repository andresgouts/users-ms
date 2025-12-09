package com.example.usersms.service;

import com.example.usersms.dto.UserInputDto;
import com.example.usersms.dto.UserOutputDto;
import com.example.usersms.mapper.UserMapper;
import com.example.usersms.model.User;
import com.example.usersms.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void testCreateUser() {
        // Given
        UserInputDto userInputDto = new UserInputDto();
        userInputDto.setEmail("test@example.com");
        userInputDto.setName("Test");
        userInputDto.setLastname("User");
        userInputDto.setUsername("testuser");

        User user = new User("test@example.com", "Test", "User", "testuser");
        User savedUser = new User("test@example.com", "Test", "User", "testuser");
        savedUser.setId(1L);

        UserOutputDto expectedUserOutputDto = new UserOutputDto(1L, "test@example.com", "Test", "User", "testuser");

        when(userMapper.toUser(any(UserInputDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        when(userMapper.toUserOutputDto(any(User.class))).thenReturn(expectedUserOutputDto);

        // When
        UserOutputDto actualUserOutputDto = userService.createUser(userInputDto);

        // Then
        assertEquals(expectedUserOutputDto.getId(), actualUserOutputDto.getId());
        assertEquals(expectedUserOutputDto.getEmail(), actualUserOutputDto.getEmail());
        assertEquals(expectedUserOutputDto.getName(), actualUserOutputDto.getName());
        assertEquals(expectedUserOutputDto.getLastname(), actualUserOutputDto.getLastname());
        assertEquals(expectedUserOutputDto.getUsername(), actualUserOutputDto.getUsername());
    }
}
