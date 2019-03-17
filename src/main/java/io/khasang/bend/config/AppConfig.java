package io.khasang.bend.config;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.dao.UserDao;
import io.khasang.bend.dao.impl.AdminDaoImpl;
import io.khasang.bend.dao.impl.BarsukDaoImpl;
import io.khasang.bend.dao.impl.SchoolDaoImpl;
import io.khasang.bend.dao.impl.UserDaoImpl;
import io.khasang.bend.entity.Admin;
import io.khasang.bend.entity.Barsuk;
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
}