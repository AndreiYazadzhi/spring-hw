package spring.dao;

import spring.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();
}
