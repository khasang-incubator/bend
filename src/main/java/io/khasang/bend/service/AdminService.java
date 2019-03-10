package io.khasang.bend.service;

import io.khasang.bend.entity.*;

import java.util.List;

public interface AdminService {

    List<School> getAllSchoolsReport();

    List<Discipline> getAllDisciplinesReport();

    List<User> getAllUsersReport();

    List<Student> getAllStudentsReport();

    List<Manager> getAllManagersReport();

    List<Photograph> getAllPhotographsReport();

    List<Student> getVacantStudentsReport();
}