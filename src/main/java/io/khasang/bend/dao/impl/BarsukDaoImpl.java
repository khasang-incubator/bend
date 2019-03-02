package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.BasicDao;
import io.khasang.bend.entity.Barsuk;

public class BarsukDaoImpl extends BasicDaoImpl<Barsuk> implements BarsukDao {
    public BarsukDaoImpl(Class entityClass) {
        super(entityClass);
    }
}
