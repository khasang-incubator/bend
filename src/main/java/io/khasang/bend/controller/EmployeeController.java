package io.khasang.bend.controller;

import io.khasang.bend.dto.EmployeeDto;
import io.khasang.bend.entity.Employee;
import io.khasang.bend.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @RequestMapping(value = "/up", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee delete(@PathVariable("id") long id) {
        return employeeService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EmployeeDto get(@PathVariable("id") long id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/getall-byname/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<EmployeeDto> getByName(@PathVariable("name") String name) {
        return employeeService.getByName(name);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<EmployeeDto> getAll() {
        return employeeService.getAllEmployees();
    }







    /*
        @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @RequestMapping(value = "/up", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee delete(@PathVariable("id") long id) {
        return employeeService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Employee get(@PathVariable("id") long id) {
        return employeeService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }
     */


}