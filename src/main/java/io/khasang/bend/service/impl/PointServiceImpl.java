package io.khasang.bend.service.impl;

import io.khasang.bend.dao.PointDao;
import io.khasang.bend.dto.PointDto;
import io.khasang.bend.entity.Point;
import io.khasang.bend.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {
    private PointDao pointDao;
    private PointDto pointDto;

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
        return pointDao.delete(pointDao.getById(id));
    }

    @Override
    public PointDto getById(long id) {
        return pointDto.getPointDtoFromPoint(pointDao.getById(id));
    }

    @Override
    public List<PointDto> getAll() {
        return pointDto.getPointDtoListFromPoints(pointDao.getAll());
    }

    @Override
    public List<PointDto> getByName(String name) {
        return pointDto.getPointDtoListFromPoints(pointDao.getByName(name));
    }

    @Autowired
    public void setPointDao(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    @Autowired
    public void setPointDto(PointDto pointDto) {
        this.pointDto = pointDto;
    }
}
