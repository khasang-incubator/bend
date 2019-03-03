package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.CarDao;
import io.khasang.bend.entity.Car;

import java.util.List;

public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {

    public CarDaoImpl(Class<Car> entityClass) {
        super(entityClass);
    }
}
