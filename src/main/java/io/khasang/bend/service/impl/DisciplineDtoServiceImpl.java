package io.khasang.bend.service.impl;

import io.khasang.bend.dao.DisciplineDao;
import io.khasang.bend.dto.DisciplineDto;
import io.khasang.bend.entity.Discipline;
import io.khasang.bend.service.DisciplineDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("disciplineDtoService")
public class DisciplineDtoServiceImpl implements DisciplineDtoService {
    private DisciplineDao disciplineDao;
    private DisciplineDto disciplineDto;

    @Override
    public Discipline add(Discipline discipline) {
        return disciplineDao.add(discipline);
    }

    @Override
    public Discipline update(Discipline discipline) {
        return disciplineDao.update(discipline);
    }

    @Override
    public Discipline delete(long id) {
        return disciplineDao.delete(disciplineDao.getById(id));
    }

    @Override
    public DisciplineDto getById(long id) {
        return disciplineDto.getDisciplineDtoFromDiscipline(disciplineDao.getById(id));
    }

    @Override
    public Set<DisciplineDto> getByName(String name) {
        return disciplineDto.getDisciplineDtoSetFromDisciplines(disciplineDao.getByName(name));
    }

    @Override
    public Set<DisciplineDto> getAll() {
        return disciplineDto.getDisciplineDtoSetFromDisciplines(disciplineDao.getAllSet());
    }

    @Autowired
    public void setDisciplineDao(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    @Autowired
    public void setDisciplineDto(DisciplineDto disciplineDto) {
        this.disciplineDto = disciplineDto;
    }
}
