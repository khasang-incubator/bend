package io.khasang.bend.service.impl.colors;

import io.khasang.bend.service.Color;
import org.springframework.stereotype.Service;

@Service
public class ColorGrey implements Color {
    private long id = 1;
    private String name;

    @Override
    public String getName() {
        return "'gray'";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + "<br>";
    }
}
