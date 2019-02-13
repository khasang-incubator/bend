package io.khasang.bend.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Service
public class Cat  {
    private String name;
    private String secretField;

    public Cat(String name, String secretField) {
        this.name = name;
        this.secretField = secretField;
    }

    public Cat() {
    }

    public String getName() {
        return name;
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

}
