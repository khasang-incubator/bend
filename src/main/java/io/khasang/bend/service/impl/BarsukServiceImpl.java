package io.khasang.bend.service.impl;

import io.khasang.bend.entity.Barsuk;
import io.khasang.bend.jpa.BarsukCrud;
import io.khasang.bend.service.BarsukService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service("barsukService")
public class BarsukServiceImpl implements BarsukService {
    private BarsukCrud barsukCrud;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Barsuk add(Barsuk barsuk) {
        return barsukCrud.save(barsuk);
    }

    @Override
    public Barsuk delete(long id) {
        Barsuk barsukFoDelete = getById(id);
        barsukCrud.delete(barsukFoDelete);
        return barsukFoDelete;
    }

    @Override
    public Barsuk getById(long id) {
        return barsukCrud.findById(id);
    }

    @Override
    public List<Barsuk> getAllBarsuk() {
        return barsukCrud.findAll();
    }

    @Override
    public List<Barsuk> getByName(String name) {
        return barsukCrud.findByName(name);
    }

    @Autowired
    public void setBarsukCrud(BarsukCrud barsukCrud) {
        this.barsukCrud = barsukCrud;
    }
}
