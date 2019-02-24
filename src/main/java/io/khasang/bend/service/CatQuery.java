package io.khasang.bend.service;

import io.khasang.bend.model.Cat;
import java.util.List;

public interface CatQuery {
    List<Cat> getAllCats();
    Cat getCatById(long id);
    String updateCatWithId(String name, String description, long id);
    String deleteCatWithId(long id);
    String addNewCat(long id, String name, String description);
}
