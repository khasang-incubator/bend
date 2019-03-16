package io.khasang.bend.service;

import io.khasang.bend.entity.Car;

import java.util.List;

public interface CarService {

    Car add(Car car);

    Car update(Car car);

    Car delete(long id);

    Car getById(long id);

    List<Car> getAll();
}