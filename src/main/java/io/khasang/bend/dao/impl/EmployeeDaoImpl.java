package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional
public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao  {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Employee> getByName(String name) {
        List<Employee> employees = getSession().createQuery("FROM Employee WHERE name = ?1")
                .setParameter(1, name).list();
        return employees;
    }
}