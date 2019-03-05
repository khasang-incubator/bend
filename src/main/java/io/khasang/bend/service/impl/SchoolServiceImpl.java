package io.khasang.bend.service.impl;

import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.entity.School;
import io.khasang.bend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {
    private SchoolDao schoolDao;

    @Override
    public School add(School school) {
        return schoolDao.add(school);
    }

    @Override
    public School update(School school) {
        return schoolDao.update(school);
    }

    @Override
    public School delete(long id) {
        return schoolDao.delete(getById(id));
    }

    @Override
    public School getById(long id) {
        return schoolDao.getById(id);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolDao.getAll();
    }

    @Autowired
    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
}