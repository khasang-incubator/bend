package io.khasang.bend.dao.impl;

import com.sun.org.apache.xpath.internal.operations.String;
import io.khasang.bend.dao.EmployeeDao;
import io.khasang.bend.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    private final Class<Employee> entityClass;
    protected SessionFactory sessionFactory;

    public EmployeeDaoImpl(Class<Employee> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Employee add(Employee entity) {
        getSession().save(entity);
        return entity;
    }

    public Employee delete(Employee entity) {
        getSession().delete(entity);
        return entity;
    }

    public Employee update(Employee entity) {
        getSession().update(entity);
        return entity;
    }

    public Employee getById(long id) {
        return getSession().get(entityClass, id);
    }

    public List getAll() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(entityClass);
        Root<Employee> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        return getSession().createQuery(criteriaQuery).list();
    }

    @Override
    public List<Employee> getAllByName(java.lang.String name) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(entityClass);
        Root<Employee> root = criteriaQuery.from(entityClass);
        //TODO am I right?
        criteriaQuery.select(root).where(builder.equal(root.get("name"), name));
        return getSession().createQuery(criteriaQuery).list();
    }
}

//public class EmployeeDaoImpl extends BasicDaoImpl<Employee> implements EmployeeDao {
//
//    public EmployeeDaoImpl(Class<Employee> entityClass) {
//        super(entityClass);
//    }
//}