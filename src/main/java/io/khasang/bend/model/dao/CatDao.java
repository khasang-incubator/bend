package io.khasang.bend.model.dao;

import io.khasang.bend.service.Cat;

public interface CatDao {//почему не видит этот интерфейс?
    public Cat create(Long id);
    public void delete(Long id);
    public void update(Long id);
}
