package io.khasang.bend.config;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.UserDao;
import io.khasang.bend.dao.impl.BarsukDaoImpl;
import io.khasang.bend.dao.impl.UserDaoImpl;
import io.khasang.bend.entity.Barsuk;
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
    public UserDao userDao() {
        return new UserDaoImpl(User.class);
    }
}
