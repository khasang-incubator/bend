package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.stereotype.Service;

@Service
public class CatImpl implements Cat {
    private int cat_id;
    private String name;
    private String description;
    private int color_id;

    public CatImpl() {
    }

    public CatImpl(int cat_id, String name, String description, int color_id) {
        this.cat_id = cat_id;
        this.name = name;
        this.description = description;
        this.color_id = color_id;
    }

    @Override
    public int getCat_id() {
        return cat_id;
    }

    @Override
    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    @Override
    public int getColor_id() {
        return color_id;
    }

    @Override
    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "cat_id = " + cat_id + " name=" + name + "  description=" + description + "  color_id=" + color_id + "<br>";
    }
}
