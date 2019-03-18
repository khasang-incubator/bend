package io.khasang.bend;

import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDtoControllerIntegrationTest {
    private final static String ROOT = "http://localhost:8080/employee";
    private final static String ADD = "/add";
    private final static String GET_BY_ID = "/get/{id}";
    private final static String GET_ALL = "/all";
    private final static String GET_ALL_BY_NAME = "/getall-byname/{name}";






//    protected SessionFactory sessionFactory;
//
//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }





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

//    @Test
//    public void checkCriteria () {
//        System.err.println("sf"+sessionFactory);
//        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
//        Root<Employee> root = criteriaQuery.from(Employee.class);
//        //TODO am I right?
//        criteriaQuery.select(root).where(builder.equal(root.get("name"), "Fransis Drake"));
//
//        List<Employee> arl = getSession().createQuery(criteriaQuery).list();
//
//        for (Employee e : arl) {
//            System.err.println(""+e.getName());
//        }
//        assertTrue(true);
//    }


    @Test
    public void checkGetAllEmployeesByName(){
        RestTemplate template = new RestTemplate();
        Employee employee = createEmployee();
        createEmployee();

        ResponseEntity<List<EmployeeDto>> result = template.exchange(
                ROOT + GET_ALL_BY_NAME,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDto>>() {
                },
                employee.getName()
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
        assertEquals("Fransis Drake", createdEmployee.getName());
        return createdEmployee;
    }

    private Employee prefillEmployee() {
        Employee employee = new Employee();
        employee.setName("Fransis Drake");
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