package spring.service;

import spring.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();
}
