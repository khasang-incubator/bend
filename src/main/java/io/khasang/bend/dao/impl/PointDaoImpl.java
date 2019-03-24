package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.PointDao;
import io.khasang.bend.entity.Point;

import java.util.*;

public class PointDaoImpl extends BasicDaoImpl<Point> implements PointDao {

    public PointDaoImpl(Class<Point> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Point> getByName(String name) {
        List<Point> points = getSession().createQuery("FROM Point WHERE name = ?1")
                .setParameter(1, name).list();
        return points;
    }
}
