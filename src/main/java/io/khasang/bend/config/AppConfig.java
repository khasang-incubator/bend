package io.khasang.bend.config;

import io.khasang.bend.dao.*;
import io.khasang.bend.dao.impl.*;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.School;
import io.khasang.bend.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public BarsukDao barsukDao() {
        return new BarsukDaoImpl(Barsuk.class);
    }

    @Bean
    public SchoolDao schoolDao() {
        return new SchoolDaoImpl(School.class);
    }

    @Bean
    public AdminDao adminDao() {
        return new AdminDaoImpl();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(User.class);
    }

    @Bean
    public PlaceDao placeDao() {
        return new PlaceDaoImpl(Place.class);
    }

    @Bean
    public PointDao pointDao(){
        return new PointDaoImpl(Point.class);
    }
}