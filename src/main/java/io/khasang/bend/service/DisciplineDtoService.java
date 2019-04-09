package io.khasang.bend.service;

import io.khasang.bend.dto.DisciplineDto;
import io.khasang.bend.entity.Discipline;

import java.util.List;

public interface DisciplineDtoService {
    Discipline add(Discipline discipline);

    Discipline update(Discipline discipline);

    Discipline delete(long id);

    DisciplineDto getById(long id);

    List<DisciplineDto> getByName(String name);

    List<DisciplineDto> getAll();
}
