package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.FoxDao;
import io.khasang.bend.entity.Fox;

public class FoxDaoImpl extends BasicDaoImpl<Fox> implements FoxDao {
    public FoxDaoImpl(Class<Fox> entityClass) {
        super(entityClass);
    }
}
