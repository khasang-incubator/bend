package io.khasang.bend.service.impl;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.entity.*;
import io.khasang.bend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    @Autowired
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<School> getAllSchoolsReport() {
        return adminDao.getAllSchoolsReport();
    }

    @Override
    public List<Discipline> getAllDisciplinesReport() {
        return adminDao.getAllDisciplinesReport();
    }

    @Override
    public List<User> getAllUsersReport() {
        return adminDao.getAllUsersReport();
    }

    @Override
    public List<Student> getAllStudentsReport() {
        return adminDao.getAllStudentsReport();
    }

    @Override
    public List<Manager> getAllManagersReport() {
        return adminDao.getAllManagersReport();
    }

    @Override
    public List<Photograph> getAllPhotographsReport() {
        return adminDao.getAllPhotographsReport();
    }

    @Override
    public List<Student> getVacantStudentsReport() {
        return adminDao.getVacantStudentsReport();
    }
}