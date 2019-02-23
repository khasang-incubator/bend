package io.khasang.bend.service;

import java.util.List;

public interface QueriesTableCats {
    String getInsertCatStatus(Cat cat);
    String getSelectCatStatus(long cat_id);
    List<Cat> getSelectAllCatsStatus();
    String getUpdateCatsStatus(int cat_id);
    String getDeleteCatStatus(Cat cat);
}
