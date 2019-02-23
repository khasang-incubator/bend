package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("murzik")
public class MurzikCat implements Cat {
    private int cat_id;
    private String name;
    private String description;
    private int color_id;

    @Override
    public String getName() {
        return "'Murzik'";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getCat_id() {
        return 2;
    }

    @Override
    public void setCat_id(int cat_id) {

    }

    @Override
    public int getColor_id() {
        return 1;
    }

    @Override
    public void setColor_id(int color_id) {

    }

    @Override
    public String getDescription() {
        return "'hungry'";
    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public String toString() {
        return "Murzik: " + "cat_id=" + cat_id + ", name=" + name +
                ", description=" + description + ", color_id=" + color_id;
    }
}
