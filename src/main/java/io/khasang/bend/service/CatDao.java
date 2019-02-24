package io.khasang.bend.service;

public interface CatDao {

    public String create(Long id, String name, String desc);
    public String update(Long id, String name, String desc);
    public String delete(Long id);
}
