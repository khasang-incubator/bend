package io.khasang.bend.dto;

import io.khasang.bend.entity.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class PointDto {
    private long id;
    private double coordN;
    private double coordW;

    public PointDto getPointDtoFromPoint(Point point) {
        PointDto pointDto = new PointDto();
        pointDto.setId(point.getId());
        pointDto.setCoordN(point.getCoordN());
        pointDto.setCoordW(point.getCoordW());
        return pointDto;
    }

    public List<PointDto> getPointDtoListFromPoints(List<Point> points) {
        List<PointDto> pointDtos = new ArrayList<>();
        for (Point point : points) {
            pointDtos.add(getPointDtoFromPoint(point));
        }
        return pointDtos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCoordN() {
        return coordN;
    }

    public void setCoordN(double coordN) {
        this.coordN = coordN;
    }

    public double getCoordW() {
        return coordW;
    }

    public void setCoordW(double coordW) {
        this.coordW = coordW;
    }
}
