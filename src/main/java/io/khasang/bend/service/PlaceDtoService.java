package io.khasang.bend.service;

import io.khasang.bend.dto.PlaceDto;
import io.khasang.bend.entity.Place;

import java.util.List;

public interface PlaceDtoService {
    Place add(Place place);

    Place update(Place place);

    Place delete(long id);

    PlaceDto getById(long id);

    List<PlaceDto> getByName(String name);

    List<PlaceDto> getAll();
}
