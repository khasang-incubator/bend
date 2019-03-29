package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.entity.Place;

import java.util.List;

public class PlaceDaoImpl extends BasicDaoImpl<Place> implements PlaceDao {

    public PlaceDaoImpl(Class<Place> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Place> getByName(String name) {
        List<Place> places = getSession().createQuery("FROM Place WHERE name = ?1")
                .setParameter(1, name).list();
        return places;
    }
}