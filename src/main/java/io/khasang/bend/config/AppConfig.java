package io.khasang.bend.config;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.FoxDao;
import io.khasang.bend.dao.impl.BarsukDaoImpl;
import io.khasang.bend.dao.impl.FoxDaoImpl;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.Fox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
//
//    @Bean
//    public Cat cat() {
//        return new Cat("Barsik", "Good");
//    }

    @Bean
    public BarsukDao barsukDao() {
        return new BarsukDaoImpl(Barsuk.class);
    }

    @Bean
    public FoxDao foxDao() {
        return new FoxDaoImpl(Fox.class);
    }
}