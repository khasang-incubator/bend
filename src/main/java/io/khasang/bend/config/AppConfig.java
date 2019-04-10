package io.khasang.bend.config;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.ManagerDao;
import io.khasang.bend.dao.PlaceDao;
import io.khasang.bend.dao.PointDao;
import io.khasang.bend.dao.RoleDao;
import io.khasang.bend.dao.SchoolDao;
import io.khasang.bend.dao.TrainerDao;
import io.khasang.bend.dao.UserDao;
import io.khasang.bend.dao.impl.AdminDaoImpl;
import io.khasang.bend.dao.impl.BarsukDaoImpl;
import io.khasang.bend.dao.impl.ManagerDaoImpl;
import io.khasang.bend.dao.impl.PlaceDaoImpl;
import io.khasang.bend.dao.impl.PointDaoImpl;
import io.khasang.bend.dao.impl.RoleDaoImpl;
import io.khasang.bend.dao.impl.SchoolDaoImpl;
import io.khasang.bend.dao.impl.TrainerDaoImpl;
import io.khasang.bend.dao.impl.UserDaoImpl;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.Manager;
import io.khasang.bend.entity.Place;
import io.khasang.bend.entity.Point;
import io.khasang.bend.entity.Role;
import io.khasang.bend.entity.School;
import io.khasang.bend.entity.Trainer;
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
    public RoleDao roleDao() {
        return new RoleDaoImpl(Role.class);
    }

    @Bean
    public PointDao pointDao() {
        return new PointDaoImpl(Point.class);
    }

    @Bean
    public ManagerDao managerDao() {
        return new ManagerDaoImpl(Manager.class);
    }

    @Bean
    TrainerDao trainerDao() {
        return new TrainerDaoImpl(Trainer.class);
    }
}