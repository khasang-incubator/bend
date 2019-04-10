package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.entity.School;

import java.util.List;

public class SchoolDaoImpl extends BasicDaoImpl<School> implements SchoolDao {
    public SchoolDaoImpl(Class<School> entityClass) {
        super(entityClass);
    }

    @Override
    public List<School> getByName(String name) {
        List<School> schools = getSession().createQuery("FROM School WHERE name = ?1")
                .setParameter(1, name).list();
        return schools;
    }

}