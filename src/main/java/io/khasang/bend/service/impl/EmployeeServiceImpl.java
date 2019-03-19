package io.khasang.bend.service.impl;


import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Employee;
import io.khasang.bend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    private EmployeeDto employeeDto;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public Employee deleteEmployee(Long id) {
        return employeeDao.delete(employeeDao.getById(id));
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return employeeDto.getEmployeeDtoFromEmployee(employeeDao.getById(id));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeDto.getEmployeeDtoListFromEmployees(employeeDao.getAll());
    }

    @Override
    public List<EmployeeDto> getAllEmployeesByName(String name) {
        return employeeDto.getEmployeeDtoListFromEmployees(employeeDao.getAllEmployeesByName(name));
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }
}
