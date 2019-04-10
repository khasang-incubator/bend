package io.khasang.bend.dao;

import io.khasang.bend.entity.School;

import java.util.List;

public interface SchoolDao extends BasicDao<School> {
    List<School> getByName(String name);
}