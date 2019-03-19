package io.khasang.bend.controller;

import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/employee";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";
    private static final String GET_ALL = "/all";

    @Test
    public void checkAddEmployee() {
        Employee employee = createEmployee();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<EmployeeDto> responseEntity = restTemplate.exchange(ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                EmployeeDto.class, employee.getId());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeDto receivedEmployee = responseEntity.getBody();
        assertNotNull(receivedEmployee);
    }

    @Test
    public void checkAllEmployees() {
        RestTemplate restTemplate = new RestTemplate();
        createEmployee();
        createEmployee();

        ResponseEntity<List<EmployeeDto>> responseEntity = restTemplate.exchange(ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDto>>() {

                }
        );
        List<EmployeeDto> employees = responseEntity.getBody();
        assertNotNull(employees);
    }

    private Employee createEmployee() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();
        HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Employee createdEmployee = restTemplate.exchange(ROOT +
                ADD, HttpMethod.POST, httpEntity, Employee.class).getBody();

        assertNotNull(createdEmployee);
        return createdEmployee;

    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("IAN");
        employee.setTitle("Java Junior");

        Car car1 = new Car();
        car1.setModel("Tesla");
        car1.setYear(LocalDate.of(2019, 1, 1));

        Car car2 = new Car();
        car2.setModel("Dodge Hellcat");
        car2.setYear(LocalDate.of(2018, 12, 12));

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        employee.setCarList(cars);

        return employee;
    }
}
