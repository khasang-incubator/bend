package io.khasang.bend.dao;

import java.util.List;
import java.util.Set;

public interface BasicDao<T> {

    T add(T entity);

    T update(T entity);

    T delete(T entity);

    T getById(long id);

    List<T> getAll();

    Set<T> getAllSet();
}
