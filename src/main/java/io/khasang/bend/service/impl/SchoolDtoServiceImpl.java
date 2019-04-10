package io.khasang.bend.service.impl;

import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.dto.SchoolDto;
import io.khasang.bend.entity.School;
import io.khasang.bend.service.SchoolDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolDtoService")
public class SchoolDtoServiceImpl implements SchoolDtoService {
    private SchoolDao schoolDao;
    private SchoolDto schoolDto;

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
        return schoolDao.delete(schoolDao.getById(id));
    }

    @Override
    public SchoolDto getById(long id) {
        return schoolDto.getSchoolDtoFromSchool(schoolDao.getById(id));
    }

    @Override
    public List<SchoolDto> getByName(String name) {
        return schoolDto.getSchoolDtoListFromSchools(schoolDao.getByName(name));
    }

    @Override
    public List<SchoolDto> getAll() {
        return schoolDto.getSchoolDtoListFromSchools(schoolDao.getAll());
    }

    @Autowired
    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Autowired
    public void setSchoolDto(SchoolDto schoolDto) {
        this.schoolDto = schoolDto;
    }
}