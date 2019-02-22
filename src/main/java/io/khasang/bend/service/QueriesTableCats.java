package io.khasang.bend.service;

import io.khasang.bend.service.impl.CatImpl;

import java.util.List;

public interface QueriesTableCats {
    String getInsertCatStatus(int cat_id, String name, String description, int color_id);
    String getSelectCatStatus(long cat_id);
    List<Cat> getSelectAllCatsStatus();
    String getUpdateCatsStatus(int cat_id);
    String getDeleteCatStatus(int cat_id);
}
