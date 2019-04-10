package io.khasang.bend.service;

import io.khasang.bend.dto.PlaceDto;
import io.khasang.bend.entity.Place;

import java.util.List;
import java.util.Set;

public interface PlaceDtoService {
    Place add(Place place);

    Place update(Place place);

    Place delete(long id);

    PlaceDto getById(long id);

    Set<PlaceDto> getByName(String name);

    Set<PlaceDto> getAll();
}
