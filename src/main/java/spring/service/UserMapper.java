package spring.service;

import org.springframework.stereotype.Component;
import spring.model.User;
import spring.service.dto.UserResponseDto;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setLogin(user.getLogin());
        return dto;
    }
}

