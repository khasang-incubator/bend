package io.khasang.bend.dao;

import io.khasang.bend.entity.Barsuk;

import java.util.List;

public interface BarsukDao extends BasicDao<Barsuk> {
    List<Barsuk> getByName(String name);
}
