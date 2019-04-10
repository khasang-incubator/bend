package io.khasang.bend.service;

import io.khasang.bend.entity.Place;

import java.util.List;
import java.util.Set;

public interface PlaceService {
    Place add(Place place);

    Place update(Place place);

    Place delete(long id);

    Place getById(long id);

    Set<Place> getByName(String name);

    Set<Place> getAllPlaces();
}
