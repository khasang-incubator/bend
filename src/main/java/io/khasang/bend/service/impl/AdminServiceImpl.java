package io.khasang.bend.service.impl;

import io.khasang.bend.dao.AdminDao;
import io.khasang.bend.entity.School;
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
    public List<School> getAllSchools() {
        return adminDao.getAllSchoolsReport();
    }
}