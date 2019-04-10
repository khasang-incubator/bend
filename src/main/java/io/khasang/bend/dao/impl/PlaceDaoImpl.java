package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.entity.Place;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlaceDaoImpl extends BasicDaoImpl<Place> implements PlaceDao {

    public PlaceDaoImpl(Class<Place> entityClass) {
        super(entityClass);
    }

    @Override
    public Set<Place> getByName(String name) {
        Set<Place> places = new HashSet<>(getSession().createQuery("FROM Place WHERE name = ?1")
                .setParameter(1, name).list());
        return places;
    }
}