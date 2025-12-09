package com.example.usersms.mapper;

import com.example.usersms.dto.UserInputDto;
import com.example.usersms.dto.UserOutputDto;
import com.example.usersms.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserInputDto userInputDto) {
        return new User(userInputDto.getEmail(), userInputDto.getName(), userInputDto.getLastname(), userInputDto.getUsername());
    }

    public UserOutputDto toUserOutputDto(User user) {
        return new UserOutputDto(user.getId(), user.getEmail(), user.getName(), user.getLastname(), user.getUsername());
    }
}
