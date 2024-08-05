package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class MatchDAO extends BaseDAO<Match> {
    public MatchDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public MatchDAO() {
        super();
    }

    @Override
    public List<Match> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select m from Match m", Match.class).list();

        }
    }

    @Override
    public Optional<Match> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Match.class, id));
        }
    }

    @Override
    public Match save(Match entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(entity);

            session.getTransaction().commit();

            return entity;
        }
    }

    @Override
    public void update(Match entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.merge(entity);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Match match = session.get(Match.class, id);
            if (match != null) {
                session.remove(id);
            }
//            session.remove(id);
//            session.flush();

            session.getTransaction().commit();
        }
    }
}
