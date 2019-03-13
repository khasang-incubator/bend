package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.PointDao;
import io.khasang.bend.entity.Point;

public class PointDaoImpl extends BasicDaoImpl<Point> implements PointDao {

    public PointDaoImpl(Class<Point> entityClass) {
        super(entityClass);
    }
}
