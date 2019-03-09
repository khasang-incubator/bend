package io.khasang.bend.dao;

import io.khasang.bend.entity.School;

import java.util.List;

public interface AdminDao {

    public List<School> getAllSchoolsReport();

}

//* add/delete/remove schools
//        * add/delete/remove users(with roles)
//        * add/delete/remove students
//        * add/delete/remove trainers
//        * add/delete/remove managers
//        * add/delete/remove photographs
//        * add/delete/remove disciplines