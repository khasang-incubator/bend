package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("murzik")
public class MurzikCat implements Cat {
    String description;

    @Override
    public String getName() {
        return "Murzik";
    }

    @Override
    public void setName(String name) {

    }

    public String getDescription() {
        return description;
    }

    @Override
    public String setDescription(String desc) {
        return "здесь должно быть описание мурзика";
    }

    @Override
    public String toString() {
        return "MurzikCat{" +
                "description='" + description + '\'' +
                '}';
    }
}
