package io.khasang.bend.controller;

import io.khasang.bend.entity.Student;
import io.khasang.bend.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Student deleteStudent(@PathVariable long id) {
        return studentService.delete(id);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
