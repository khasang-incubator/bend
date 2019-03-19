package io.khasang.bend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDto {
    private Long id;
    private String model;
    private LocalDate year;
    private List<EmployeeDto> employees = new ArrayList<>();

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
