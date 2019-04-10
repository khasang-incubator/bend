package io.khasang.bend.dao;

import io.khasang.bend.entity.User;

import java.util.List;

public interface UserDao extends BasicDao<User> {
    List<User> getAllUsersByName(String name);
}