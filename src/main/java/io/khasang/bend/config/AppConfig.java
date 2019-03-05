package io.khasang.bend.config;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.impl.BarsukDaoImpl;
import io.khasang.bend.entity.Barsuk;
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

}
