package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class BarsikCat implements Cat {
    private int cat_id;
    private String name;
    private String description;
    private int color_id;

    public BarsikCat() {
    }

    public BarsikCat(int cat_id, String name, String description, int color_id) {
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
        return 2;
    }
    @Override
    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    @Override
    public String getName() {
        return "'Barsik'";
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return "'good'";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @PreDestroy
    public void getInfo() {
        System.out.println("!!!!!!adadad");
    }

}
