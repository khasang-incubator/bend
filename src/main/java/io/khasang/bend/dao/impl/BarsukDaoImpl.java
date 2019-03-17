package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.BarsukDao;
import io.khasang.bend.entity.Barsuk;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BarsukDaoImpl extends BasicDaoImpl<Barsuk> implements BarsukDao {
    public BarsukDaoImpl(Class<Barsuk> entityClass) {
        super(entityClass);
    }

    public List<Barsuk> getByName(String name) {
//        List<Barsuk> barsukList = getSession().createQuery("from Barsuk where name = :name")
//        .setParameter("name", name).list();
//        List<Barsuk> getCatsByName(String name) {
//
//
//            CriteriaBuilder builder = getSession().getCriteriaBuilder();
//            CriteriaQuery<Barsuk> criteriaQuery = builder.createQuery(Barsuk.class);
//            Root<Barsuk> root = criteriaQuery.from(Barsuk.class);
//
//            criteriaQuery.select(root);
//            criteriaQuery.where(builder.equal(root.get("name"), name));
//
//            TypedQuery<Barsuk> typedQuery = getSession().createQuery(criteriaQuery);
//            return typedQuery.getResultList();
        List<Barsuk> barsukList = getSession().createQuery("from Barsuk where name = ?1")
                .setParameter(1, name).list();
        return barsukList;
    }
}
