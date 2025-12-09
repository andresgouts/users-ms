package com.example.usersms.service;

import com.example.usersms.dto.UserInputDto;
import com.example.usersms.dto.UserOutputDto;
import com.example.usersms.mapper.UserMapper;
import com.example.usersms.model.User;
import com.example.usersms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserOutputDto createUser(UserInputDto userInputDto) {
        User user = userMapper.toUser(userInputDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserOutputDto(savedUser);
    }
}
