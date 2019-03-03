package io.khasang.bend.service.impl;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.dao.FoxDao;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.entity.Fox;
import io.khasang.bend.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("foxService")
public class FoxServiceImpl implements FoxService {

    private FoxDao foxDao;

    @Override
    public Fox add(Fox fox) {
        return foxDao.add(fox);
    }

    @Override
    public Fox update(Fox fox) {
        return foxDao.update(fox);
    }

    @Override
    public Fox delete(long id) {
        return foxDao.delete(getById(id));
    }

    @Override
    public Fox getById(long id) {
        return foxDao.getById(id);
    }

    @Override
    public List<Fox> getAllFoxes() {
        return foxDao.getAll();
    }

    @Autowired
    public void setFoxDao(FoxDao foxDao) {
        this.foxDao = foxDao;
    }
}