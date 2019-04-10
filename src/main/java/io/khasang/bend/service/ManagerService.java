package io.khasang.bend.service;

import io.khasang.bend.entity.Manager;

import java.util.List;

public interface ManagerService {
    Manager addManager(Manager manager);

    Manager updateManager(Manager manager);

    Manager deleteManager(long id);

    Manager getById(long id);

    List<Manager> getAllManagers();
}
