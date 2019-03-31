package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("murzik")
public class MurzikCat implements Cat {
    @Override
    public String getName() {
        return "Murzik";
    }

    @Override
    public void setName(String name) {

    }
}
