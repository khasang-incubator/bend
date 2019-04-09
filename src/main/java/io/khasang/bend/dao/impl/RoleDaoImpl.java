package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.RoleDao;
import io.khasang.bend.entity.Role;

import java.util.List;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }
}
