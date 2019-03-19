package io.khasang.bend.service;

import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(Long id);

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployee();

    List<EmployeeDto> getAllEmployeesByName(String name);
}
