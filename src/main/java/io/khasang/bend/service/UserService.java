package io.khasang.bend.service;

import io.khasang.bend.dto.UserDto;
import io.khasang.bend.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);

    User update(User user);

    User delete(long id);

    UserDto getById(long id);

    List<UserDto> getAllUsers();

    List<UserDto> getAllUsersByName(String name);
}
