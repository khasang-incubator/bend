package io.khasang.bend.service;

import io.khasang.bend.dto.DisciplineDto;
import io.khasang.bend.entity.Discipline;

import java.util.List;
import java.util.Set;

public interface DisciplineDtoService {
    Discipline add(Discipline discipline);

    Discipline update(Discipline discipline);

    Discipline delete(long id);

    DisciplineDto getById(long id);

    Set<DisciplineDto> getByName(String name);

    Set<DisciplineDto> getAll();
}
