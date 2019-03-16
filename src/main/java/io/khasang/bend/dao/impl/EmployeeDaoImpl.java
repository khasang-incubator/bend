package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {

    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }
}