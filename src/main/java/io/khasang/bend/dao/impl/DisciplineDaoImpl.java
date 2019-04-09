package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.DisciplineDao;
import io.khasang.bend.entity.Discipline;

import java.util.List;

public class DisciplineDaoImpl extends BasicDaoImpl<Discipline> implements DisciplineDao {
    public DisciplineDaoImpl(Class<Discipline> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Discipline> getByName(String name) {
        List<Discipline> disciplines = getSession().createQuery("FROM Discipline WHERE name = ?1")
                .setParameter(1, name).list();
        return disciplines;
    }
}
