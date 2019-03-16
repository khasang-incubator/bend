package io.khasang.bend.service.impl;

import io.khasang.bend.dao.CarDao;
import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import io.khasang.bend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Override
    public Car add(Car car) {
        //System.err.println("barsuk"+employee.getName()+employee.getDescription());
        return carDao.add(car);
    }

    @Override
    public Car update(Car car) {
        return carDao.update(car);
    }

    @Override
    public Car delete(long id) {
        return carDao.delete(getById(id));
    }

    @Override
    public Car getById(long id) {
        return carDao.getById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }
}
