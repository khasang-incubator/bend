package io.khasang.bend.dao;

import io.khasang.bend.entity.Discipline;

import java.util.List;

public interface DisciplineDao extends BasicDao<Discipline> {
    List<Discipline> getByName(String name);
}
