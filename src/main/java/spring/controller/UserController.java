package spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.model.User;
import spring.service.UserMapper;
import spring.service.UserService;
import spring.service.dto.UserResponseDto;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable(name = "userId") Long id) {
        return userMapper.toDto(userService.get(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/inject")
    public String inject() {
        User[] users = new User[4];
        String name = "Bob";
        for (int i = 0; i < users.length; i++) {
            users[i] = new User();
            users[i].setLogin(name + i);
            users[i].setPassword("Alice" + i);
            userService.add(users[i]);
        }
        return "Users injected!";
    }
}
