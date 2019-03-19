package io.khasang.bend.dao;

import io.khasang.bend.entity.Point;

import java.util.List;

public interface PointDao extends BasicDao<Point> {
    List<Point> getByName(String name);
}
