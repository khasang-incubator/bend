package io.khasang.bend.config;

import io.khasang.bend.dao.CarDao;
import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.dao.PointDao;
import io.khasang.bend.dao.UserDao;
import io.khasang.bend.dao.impl.CarDaoImpl;
import io.khasang.bend.dao.impl.EmployeeDaoImpl;
import io.khasang.bend.dao.impl.UserDaoImpl;
import io.khasang.bend.entity.Car;
import io.khasang.bend.entity.Employee;
import io.khasang.bend.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImpl(Employee.class);
    }

    @Bean
    public CarDao carDao(){
        return new CarDaoImpl(Car.class);
    }

    @Bean
    public PointDao pointDao(){
        return new PointDaoImpl(Point.class);
    }

    @Bean
    public UserDao userDao(){
        return new UserDaoImpl(User.class);
    }
}
