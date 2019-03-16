package io.khasang.bend.dto;

import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDto {

    private Long id;
    private String name;
    private String title;
    private List<CarDto> carList = new ArrayList<>();

    public EmployeeDto getEmployeeDtoFromEmployee(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setId(employee.getId());
        employeeDto.setTitle(employee.getTitle());

        List<CarDto> carDtos = new ArrayList<>();
        for (Car car: employee.getCarList()){
            CarDto carDto = new CarDto();
            carDto.setId(car.getId());
            carDto.setModel(car.getModel());
            carDto.setYear(car.getYear());
            carDtos.add(carDto);
        }
        employeeDto.setCarList(carDtos);
        return employeeDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }
}
