package io.khasang.bend.dao;

import io.khasang.bend.entity.User;

import java.util.Set;

public interface UserDao extends BasicDao<User> {
    Set<User> getAllUsersByName(String name);
}