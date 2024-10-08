package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class BaseDAO<T> {
    protected final SessionFactory sessionFactory;

    public BaseDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public BaseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public abstract List<T> findAll();

    public abstract Optional<T> findById(Long id);

    public abstract T save(T entity);

    public abstract void delete(Long id);
}
