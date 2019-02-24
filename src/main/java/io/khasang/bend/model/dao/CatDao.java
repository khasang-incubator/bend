package io.khasang.bend.model.dao;

import io.khasang.bend.service.Cat;

public interface CatDao {//почему не видит этот интерфейс?
    public String create(Long id, String name, String desc);
    public String update(String name, String desc, Long id);
    public String delete(Long id);
}
