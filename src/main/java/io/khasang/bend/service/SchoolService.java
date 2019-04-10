package io.khasang.bend.service;

import io.khasang.bend.entity.School;

import java.util.List;
import java.util.Set;

public interface SchoolService {
    School add(School school);

    School update(School school);

    School delete(long id);

    School getById(long id);

    Set<School> getByName(String name);

    Set<School> getAll();
}