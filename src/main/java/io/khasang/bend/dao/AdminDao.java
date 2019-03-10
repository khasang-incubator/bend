package io.khasang.bend.dao;

import io.khasang.bend.entity.*;

import java.util.List;

public interface AdminDao {

    public List<School> getAllSchoolsReport();

    public List<Discipline> getAllDisciplinesReport();

    public List<User> getAllUsersReport();

    public List<Student> getAllStudentsReport();

    public List<Trainer> getAllTrainersReport();

    public List<Manager> getAllManagersReport();

    public List<Photograph> getAllPhotographsReport();

    public List<Student> getVacantStudentsReport();

}