package io.khasang.bend.service;

import io.khasang.bend.dto.SchoolDto;
import io.khasang.bend.entity.School;

import java.util.List;

public interface SchoolDtoService {
    School add(School school);

    School update(School school);

    School delete(long id);

    SchoolDto getById(long id);

    List<SchoolDto> getByName(String name);

    List<SchoolDto> getAll();
}