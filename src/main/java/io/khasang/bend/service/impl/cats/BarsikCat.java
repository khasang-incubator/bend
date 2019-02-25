package io.khasang.bend.service.impl.cats;

import io.khasang.bend.service.Cat;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class BarsikCat implements Cat {
    private String name;
    private int cat_id = 1;
    private String description = "'good'";

    @Override
    public String getName() {
        return "'Barsik'";
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @PreDestroy
    public void getInfo() {
        System.out.println("!!!!!!adadad");
    }

    @Override
    public String toString() {
        return "cat_id=" + cat_id + ", name=" + name +
                ", description=" + description + ", color_id=" + "<br>";
    }
}
