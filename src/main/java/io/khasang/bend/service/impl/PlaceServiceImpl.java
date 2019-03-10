package io.khasang.bend.service.impl;


import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.entity.Place;
import io.khasang.bend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {
    private PlaceDao placeDao;

    @Override
    public Place add(Place place) {
        return placeDao.add(place);
    }

    @Override
    public Place update(Place place) {
        return placeDao.update(place);
    }

    @Override
    public Place delete(long id) {
        return placeDao.delete(getById(id));
    }

    @Override
    public Place getById(long id) {
        return placeDao.getById(id);
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeDao.getAll();
    }

    @Autowired
    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }
}