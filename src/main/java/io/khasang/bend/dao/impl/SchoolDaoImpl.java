package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.entity.School;

public class SchoolDaoImpl extends BasicDaoImpl<School> implements SchoolDao {
    public SchoolDaoImpl(Class<School> entityClass) {
        super(entityClass);
    }
}