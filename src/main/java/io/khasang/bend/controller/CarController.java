package io.khasang.bend.controller;

import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import io.khasang.bend.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car add(@RequestBody Car car) {
        return carService.add(car);
    }

    @RequestMapping(value = "/up",  method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @RequestMapping(value = "/del/{id}",  method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car add(@PathVariable("id") long id) {
        return carService.delete(id);
    }

    @RequestMapping(value = "/get/{id}",  method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car get(@PathVariable("id") long id) {
        return carService.getById(id);
    }

    @RequestMapping(value = "/get/all",  method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Car> getAll() {
        return carService.getAllCars();
    }
}
