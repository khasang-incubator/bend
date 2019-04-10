package io.khasang.bend.dao;

import io.khasang.bend.entity.School;

import java.util.Set;

public interface SchoolDao extends BasicDao<School> {
    Set<School> getByName(String name);
}