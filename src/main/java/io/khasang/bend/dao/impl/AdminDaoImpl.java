package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
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

//    getAllStudentsReport()
//    getAllVacantStudentsReport()
//    getAllUsersReport()
//    getAllSchoolsReport()
//    getAllTrainersReport()
//    getAllManagersReport()
//    getAllPhotographsReport()
//    getAllDisciplinesReport()

    public EntityManager getEntityManager() {
        return entityManager;
    }

    //@Autowired
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}