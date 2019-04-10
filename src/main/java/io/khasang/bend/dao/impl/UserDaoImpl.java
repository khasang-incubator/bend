package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.UserDao;
import io.khasang.bend.entity.User;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
    public UserDaoImpl(Class<User> entityClass) {
        super(entityClass);
    }

    @Override
    public Set<User> getAllUsersByName(String name) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));
        TypedQuery<User> typedQuery = getSession().createQuery(criteriaQuery);
        List<User> list = typedQuery.getResultList();
        return new HashSet<User>(list);
    }
}
