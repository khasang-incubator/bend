package io.khasang.bend.service.impl;

import io.khasang.bend.dao.ManagerDao;
import io.khasang.bend.entity.Manager;
import io.khasang.bend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    @Override
    public Manager addManager(Manager manager) {
        return managerDao.add(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerDao.update(manager);
    }

    @Override
    public Manager deleteManager(long id) {
        return managerDao.delete(managerDao.getById(id));
    }

    @Override
    public Manager getById(long id) {
        return managerDao.getById(id);
    }

    @Override
    public List<Manager> getAllManagers() {
        return managerDao.getAll();
    }

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
}
