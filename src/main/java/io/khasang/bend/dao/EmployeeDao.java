package io.khasang.bend.dao;

import io.khasang.bend.entity.Employee;

import java.util.List;

public interface EmployeeDao extends BasicDao<Employee> {
    List<Employee> getByName(String name);
}
