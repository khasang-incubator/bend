package io.khasang.bend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
public class DataConfig {
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    //for prod  авторизация через БД (auth.properties)
    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl dao = new JdbcDaoImpl();
        dao.setDataSource(dataSource());
        dao.setUsersByUsernameQuery(environment.getRequiredProperty("usersByQuery")); // для понимания, что такой user существует, с таким логином
        dao.setAuthoritiesByUsernameQuery(environment.getRequiredProperty("rolesByQuery")); // есть ли у юзера нужная нам роль
        return dao;
    }

    // non for prod
//    @Bean
//    public UserDetailsService userDetailsService() throws Exception {
//        // ensure the passwords are encoded properly
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("user").roles("USER").build());
//        manager.createUser(users.username("user2").password("user2").roles("USER").build());
//        manager.createUser(users.username("admin").password("admin").roles("USER","ADMIN").build());
//        manager.createUser(users.username("admin2").password("admin2").roles("USER","ADMIN").build());
//        return manager;
//    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
