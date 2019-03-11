package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.BasicDao;
import io.khasang.bend.dao.TrainerDao;
import io.khasang.bend.entity.Trainer;

public class TrainerDaoImpl extends BasicDaoImpl<Trainer> implements TrainerDao {
    public TrainerDaoImpl(Class<Trainer> entityClass) {
        super(entityClass);
    }
}
