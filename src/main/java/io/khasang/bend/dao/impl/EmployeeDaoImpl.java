package io.khasang.bend.dao.impl;

import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.entity.Employee;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(Class<Employee> entityClass) {
        super(entityClass);
    }

    public List<Employee> getAllEmployeesByName(String name) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);

        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));
        TypedQuery<Employee> typedQuery = getSession().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
