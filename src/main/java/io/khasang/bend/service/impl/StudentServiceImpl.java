package io.khasang.bend.service.impl;

import io.khasang.bend.dao.StudentDao;
import io.khasang.bend.entity.Student;
import io.khasang.bend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

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
    public Student getById(long id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
