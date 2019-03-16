package io.khasang.bend;

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

import static org.junit.Assert.*;

public class EmployeeDtoControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/employee";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get/{id}";
    private final static String GET_ALL = "/all";

    @Test
    public void checkAddEmployee() {
        Employee employee = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<EmployeeDto> responseEntity = template.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                EmployeeDto.class,
                employee.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        EmployeeDto recievedEmployee = responseEntity.getBody();
        assertNotNull(recievedEmployee);
    }

    @Test
    public void checkGetAllEmployees(){
        RestTemplate template = new RestTemplate();
        createEmployee();
        createEmployee();

        ResponseEntity<List<EmployeeDto>> result = template.exchange(
                ROOT + GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDto>>() {
                }
        );

        List<EmployeeDto> employees = result.getBody();
        assertNotNull(employees);
    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee();

        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        RestTemplate template = new RestTemplate();

        Employee createdEmployee = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                entity,
                Employee.class
        ).getBody();

        assertNotNull(createdEmployee);
        assertEquals("Henry Morgan", createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Henry Morgan");
        employee.setTitle("clerk");

        Car car1 = new Car();
        car1.setModel("Ford");
        car1.setYear(LocalDate.of(2011,12,21));

        Car car2 = new Car();
        car2.setModel("Audi");
        car2.setYear(LocalDate.of(2012,10,5));

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        employee.setCarList(carList);

        return employee;
    }
}