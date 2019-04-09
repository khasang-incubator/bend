package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.StudentDao;
import io.khasang.bend.entity.Student;

public class StudentDaoImpl extends BasicDaoImpl<Student> implements StudentDao {
    public StudentDaoImpl(Class<Student> entityClass) {
        super(entityClass);
    }

}
