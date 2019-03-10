package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.entity.*;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class AdminDaoImpl implements AdminDao {

    protected EntityManager entityManager;

    public AdminDaoImpl() {}

    public List<School> getAllSchoolsReport(){
        String sql = "SELECT * FROM schools";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Discipline> getAllDisciplinesReport(){
        String sql = "SELECT * FROM disciplines";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<User> getAllUsersReport(){
        String sql = "SELECT * FROM users";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Student> getAllStudentsReport(){
        String sql = "SELECT * FROM students";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Trainer> getAllTrainersReport(){
        String sql = "SELECT * FROM trainers";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Manager> getAllManagersReport(){
        String sql = "SELECT * FROM managers";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Photograph> getAllPhotographsReport(){
        String sql = "SELECT * FROM photographs";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public List<Student> getVacantStudentsReport(){
        String sql = "SELECT * FROM students WHERE student.vacant = TRUE";
        return getEntityManager().createNativeQuery(sql).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    //@Autowired
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}