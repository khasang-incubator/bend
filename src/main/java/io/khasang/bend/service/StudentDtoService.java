package io.khasang.bend.service;

import io.khasang.bend.dto.StudentDto;
import io.khasang.bend.entity.Student;

import java.util.List;

public interface StudentDtoService {
    Student add(Student student);

    Student update(Student student);

    Student delete(long id);

    StudentDto getById(long id);

    List<StudentDto> getAll();
}
