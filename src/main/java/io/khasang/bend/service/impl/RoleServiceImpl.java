package io.khasang.bend.service.impl;

import io.khasang.bend.dao.RoleDao;
import io.khasang.bend.entity.Role;
import io.khasang.bend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public Role delete(long id) {
        return roleDao.delete(getById(id));
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public List<Role> getAllRols() {
        return roleDao.getAll();
    }

    @Autowired

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
