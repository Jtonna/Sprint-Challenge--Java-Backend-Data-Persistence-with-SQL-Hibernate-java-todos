package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserByUsername(String username);

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);
}