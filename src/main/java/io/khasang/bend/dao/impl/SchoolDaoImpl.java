package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.entity.School;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchoolDaoImpl extends BasicDaoImpl<School> implements SchoolDao {
    public SchoolDaoImpl(Class<School> entityClass) {
        super(entityClass);
    }

    @Override
    public Set<School> getByName(String name) {
        Set<School> schools = new HashSet<>(getSession().createQuery("FROM School WHERE name = ?1")
                .setParameter(1, name).list());
        return schools;
    }
}