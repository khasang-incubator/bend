package io.khasang.bend.service.impl;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.service.BarsukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("barsukService")
public class BarsukServiceImpl implements BarsukService {

    private BarsukDao barsukDao;


    @Override
    public Barsuk add(Barsuk barsuk) {
        System.err.println("barsuk"+barsuk.getName()+barsuk.getDescription());
        return barsukDao.add(barsuk);
    }

    @Override
    public Barsuk update(Barsuk barsuk) {
        return barsukDao.update(barsuk);
    }

    @Override
    public Barsuk delete(long id) {
        return barsukDao.delete(getById(id));
    }

    @Override
    public Barsuk getById(long id) {
        return barsukDao.getById(id);
    }

    @Override
    public List<Barsuk> getAllBarsuk() {
        return barsukDao.getAll();
    }

    @Autowired
    public void setBarsukDao(BarsukDao barsukDao) {
        this.barsukDao = barsukDao;
    }
}
