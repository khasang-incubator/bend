package io.khasang.bend.dao;

import io.khasang.bend.entity.Place;

import java.util.List;

public interface PlaceDao extends BasicDao<Place> {
    List<Place> getByName(String name);
}