package io.khasang.bend.dao;

import io.khasang.bend.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee add(Employee entity);
    Employee delete(Employee entity);
    Employee update(Employee entity);
    Employee getById(long id);
    List<Employee> getAll();
    List<Employee> getAllByName(String name);
}
