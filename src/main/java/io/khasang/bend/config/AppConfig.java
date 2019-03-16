package io.khasang.bend.config;

import io.khasang.bend.dao.*;
import io.khasang.bend.dao.impl.*;
import io.khasang.bend.entity.*;
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

    @Bean
    public SchoolDao schoolDao() {
        return new SchoolDaoImpl(School.class);
    }

    @Bean
    public TrainerDao trainerDao() {
        return new TrainerDaoImpl(Trainer.class);
    }

    @Bean
    public CarDao carDao() {
        return new CarDaoImpl(Car.class);
    }

    @Bean
    public EmployeeDao employeeDao (){
        return new EmployeeDaoImpl(Employee.class);
    }
}