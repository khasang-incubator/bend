package io.khasang.bend.service.impl;

import io.khasang.bend.service.Cat;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class BarsikCat implements Cat {
    private String name;
    private String secretField;
    private String description;

    public BarsikCat(String name, String secretField) {
        this.name = name;
        this.secretField = secretField;
    }

    public BarsikCat() {
    }

    public String getName() {
        return "Barsik";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String setDescription(String desc) {
        return "здесь должно быть описание барсика";
    }

    public String getSecretField() {
        return secretField;
    }

    public void setSecretField(String secretField) {
        this.secretField = secretField;
    }

    //
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//
    @PreDestroy
    public void getInfo() {
        System.out.println("!!!!!!adadad");
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BarsikCat{" +
                "name='" + name + '\'' +
                ", secretField='" + secretField + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
