package io.khasang.bend.service;

import io.khasang.bend.entity.Point;

import java.util.List;

public interface PointService {
    Point add(Point point);

    Point update(Point point);

    Point delete(long id);

    Point getById(long id);

    List<Point> getAll();
}
