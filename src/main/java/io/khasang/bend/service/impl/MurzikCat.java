package io.khasang.bend.service.impl;

import io.khasang.bend.model.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("murzik")
public class MurzikCat extends Cat {
    @Override
    public String getName() {
        return "Murzik";
    }

    @Override
    public void setName(String name) {

    }
}
