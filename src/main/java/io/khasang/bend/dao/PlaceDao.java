package io.khasang.bend.dao;

import io.khasang.bend.entity.Place;

import java.util.List;
import java.util.Set;

public interface PlaceDao extends BasicDao<Place> {
    Set<Place> getByName(String name);
}