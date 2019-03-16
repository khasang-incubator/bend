package io.khasang.bend.service;

import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(Employee employee);

    Employee update(Employee employee);

    Employee delete(long id);

    EmployeeDto getById(long id);

    List<Employee> getAllEmployees();


    /*
        Employee add(Employee employee);

    Employee update(Employee employee);

    Employee delete(long id);

    Employee getById(long id);

    List<Employee> getAllEmployees();
     */

}