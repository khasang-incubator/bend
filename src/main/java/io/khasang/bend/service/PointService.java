package io.khasang.bend.service;

import io.khasang.bend.dto.PointDto;
import io.khasang.bend.entity.Point;

import java.util.List;

public interface PointService {

    Point add(Point point);

    Point update(Point point);

    Point delete(long id);

    PointDto getById(long id);

    List<PointDto> getAll();

    List<PointDto> getByName(String name);
}
