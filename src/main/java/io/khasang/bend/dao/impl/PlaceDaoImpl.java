package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.entity.Place;

public class PlaceDaoImpl extends BasicDaoImpl<Place> implements PlaceDao {
    public PlaceDaoImpl(Class<Place> entityClass) {
        super(entityClass);
    }
}