package io.khasang.bend.service;

import io.khasang.bend.entity.Place;

import java.util.List;

public interface PlaceService {
    Place add(Place place);

    Place update(Place place);

    Place delete(long id);

    Place getById(long id);

    List<Place> getByName(String name);

    List<Place> getAllPlaces();
}
