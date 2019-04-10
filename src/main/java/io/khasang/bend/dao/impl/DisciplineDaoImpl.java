package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.DisciplineDao;
import io.khasang.bend.entity.Discipline;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisciplineDaoImpl extends BasicDaoImpl<Discipline> implements DisciplineDao {
    public DisciplineDaoImpl(Class<Discipline> entityClass) {
        super(entityClass);
    }

    @Override
    public Set<Discipline> getByName(String name) {
        Set<Discipline> disciplines = new HashSet(getSession().createQuery("FROM Discipline WHERE name = ?1")
                .setParameter(1, name).list());
        return disciplines;
    }
}
