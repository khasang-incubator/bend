package io.khasang.bend.service;

import io.khasang.bend.entity.Barsuk;

import java.util.List;

public interface BarsukService {

    Barsuk add(Barsuk barsuk);
    Barsuk update(Barsuk barsuk);
    Barsuk delete(long id);
    Barsuk getById(long id);
    List<Barsuk> getAllBarsuk();
}
