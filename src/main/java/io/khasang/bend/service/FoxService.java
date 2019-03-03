package io.khasang.bend.service;

import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.Fox;

import java.util.List;

public interface FoxService {

    Fox add(Fox fox);
    Fox update(Fox fox);
    Fox delete(long id);
    Fox getById(long id);
    List<Fox> getAllFoxes();
}
