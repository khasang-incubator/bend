package io.khasang.bend.service.impl;

import io.khasang.bend.dao.StudentDao;
import io.khasang.bend.dto.StudentDto;
import io.khasang.bend.entity.Student;
import io.khasang.bend.service.StudentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDtoServiceImpl implements StudentDtoService {
    private StudentDao studentDao;
    private StudentDto studentDto;

    @Override
    public Student add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public Student delete(long id) {
        return studentDao.delete(studentDao.getById(id));
    }

    @Override
    public StudentDto getById(long id) {
        return studentDto.getStudentDtoFromStudent(studentDao.getById(id));
    }

    @Override
    public List<StudentDto> getAll() {
        return studentDto.getStudentDtoFromStudents(studentDao.getAll());
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }
}
