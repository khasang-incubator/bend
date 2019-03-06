package io.khasang.bend.service;

import io.khasang.bend.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User update(User user);

    User delete(long id);

    User getById(long id);

    List<User> getAllUsers();
}
