package io.khasang.bend.dao;

import io.khasang.bend.entity.Discipline;

import java.util.List;
import java.util.Set;

public interface DisciplineDao extends BasicDao<Discipline> {
    Set<Discipline> getByName(String name);
}
