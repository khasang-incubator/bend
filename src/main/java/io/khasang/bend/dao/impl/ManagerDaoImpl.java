package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.ManagerDao;
import io.khasang.bend.entity.Manager;

public class ManagerDaoImpl extends BasicDaoImpl<Manager> implements ManagerDao {
    public ManagerDaoImpl(Class<Manager> entityClass) {
        super(entityClass);
    }
}
