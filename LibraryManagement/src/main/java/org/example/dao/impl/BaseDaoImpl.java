package org.example.dao.impl;

import org.example.dao.BaseDao;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<E, ID extends Serializable> implements BaseDao<E, ID> {

    private Class<E> entityType;

    private SessionFactory sessionFactory;

    public BaseDaoImpl(Class<E> entityType){
        this.entityType = entityType;
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public ID save(E e) {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Serializable id =  session.save(e);
            session.getTransaction().commit();
            return (ID) id;
        }
    }

    @Override
    public List<E> getAll() {
        List<E> data;
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Query<E> query = session.createQuery("from " + entityType.getSimpleName(), entityType);
            data = query.getResultList();
            session.getTransaction().commit();
            return data;
        }
    }

    @Override
    public E getOne(ID id) {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            E entity = session.get(entityType, id);
            session.getTransaction().commit();
            return entity;
        }
    }

    @Override
    public void update(E e) {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.update(e);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ID id) {
        E e = getOne(id);
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.delete(e);
            session.getTransaction().commit();
        }
    }

}
