package io.khasang.bend.service;

import io.khasang.bend.entity.Role;

import java.util.List;

public interface RoleService {
    Role add(Role role);

    Role update(Role role);

    Role delete(long id);

    Role getById(long id);

    List<Role> getAllRols();
}
