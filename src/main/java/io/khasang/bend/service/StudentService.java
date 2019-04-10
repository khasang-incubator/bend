package io.khasang.bend.service;

import io.khasang.bend.entity.Student;

import java.util.List;

public interface StudentService {

    Student add(Student student);

    Student update(Student student);

    Student delete(long id);

    Student getById(long id);

    List<Student> getAllStudents();
}
