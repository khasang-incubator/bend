package io.khasang.bend.dto;

import io.khasang.bend.entity.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PointDto {
    private long id;
    private String name;
    private double coordX;
    private double coordY;
    private String description;

    public PointDto getPointDtoFromPoint(Point point) {
        PointDto pointDto = new PointDto();
        pointDto.setId(point.getId());
        pointDto.setName(point.getName());
        pointDto.setCoordX(point.getCoordX());
        pointDto.setCoordY(point.getCoordY());
        pointDto.setDescription(point.getDescription());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
