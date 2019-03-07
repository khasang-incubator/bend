package io.khasang.bend.service.impl;

import io.khasang.bend.dao.PointDao;
import io.khasang.bend.entity.Point;
import io.khasang.bend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private PointDao pointDao;

    @Override
    public Point add(Point point) {
        return pointDao.add(point);
    }

    @Override
    public Point update(Point point) {
        return pointDao.update(point);
    }

    @Override
    public Point delete(long id) {
        return pointDao.delete(getById(id));
    }

    @Override
    public Point getById(long id) {
        return pointDao.getById(id);
    }

    @Override
    public List<Point> getAllPoints() {
        return pointDao.getAll();
    }

    @Autowired
    public void setPointDao(PointDao pointDao) {
        this.pointDao = pointDao;
    }
}

