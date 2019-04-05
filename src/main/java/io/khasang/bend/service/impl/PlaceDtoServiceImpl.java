package io.khasang.bend.service.impl;


import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.dto.PlaceDto;
import io.khasang.bend.entity.Place;
import io.khasang.bend.service.PlaceDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("placeServiceDto")
public class PlaceDtoServiceImpl implements PlaceDtoService {
    private PlaceDao placeDao;
    private PlaceDto placeDto;

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
        return placeDao.delete(placeDao.getById(id));
    }

    @Override
    public PlaceDto getById(long id) {
        return placeDto.getPlaceDtoFromPlace(placeDao.getById(id));
    }

    @Override
    public List<PlaceDto> getByName(String name) {
        return placeDto.getPlaceDtoListFromPlaces(placeDao.getByName(name));
    }

    @Override
    public List<PlaceDto> getAll() {
        return placeDto.getPlaceDtoListFromPlaces(placeDao.getAll());
    }

    @Autowired
    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Autowired
    public void setPlaceDto(PlaceDto placeDto) {
        this.placeDto = placeDto;
    }
}