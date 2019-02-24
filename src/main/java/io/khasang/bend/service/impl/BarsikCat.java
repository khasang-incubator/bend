package io.khasang.bend.service.impl;

import io.khasang.bend.model.Cat;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class BarsikCat extends Cat {
    private Long id;
    private String name;
    private String secretField;

    @Override
    public String toString() {
        return "BarsikCat{" +
                "name='" + name + '\'' +
                ", secretField='" + secretField + '\'' +
                '}';
    }

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

    public void setId(Long id) {
        this.id = id;
    }
}
