package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.UserDao;
import io.khasang.bend.entity.User;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }
}
