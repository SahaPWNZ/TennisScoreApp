package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.util.HibernateUtil;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public List<Match> findAllByPlayerName(String name, int pageNumber){
        int pageSize =3;
        int offSet = (pageNumber -1)* pageSize;

        try(Session session = sessionFactory.openSession()){
            Query<Match> query = session.createQuery
                    ("select m from Match m where m.player1.name = :firstName or m.player2.name=:secondName", Match.class);
            query.setParameter("firstName", name);
            query.setParameter("secondName", name);
            query.setMaxResults(pageSize);
            query.setFirstResult(offSet);
            return query.list();
        }
    }

    public List<Match> findAllByPlayerName(String name) {
        try(Session session = sessionFactory.openSession()){
            Query<Match> query = session.createQuery
                    ("select m from Match m where m.player1.name = :firstName or m.player2.name=:secondName", Match.class);
            query.setParameter("firstName", name);
            query.setParameter("secondName", name);
            return query.list();
        }
    }
    public List<Match> findAllMatchesForPagination (int pageNumber){
        int pageSize =3;
        int offSet = (pageNumber -1)* pageSize;

        try(Session session = sessionFactory.openSession()){
            Query<Match> query = session.createQuery
                    ("select m from Match m", Match.class);
            query.setMaxResults(pageSize);
            query.setFirstResult(offSet);
            return query.list();
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

//    @Override
//    public void update(Match entity) {
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            session.merge(entity);
//
//            session.getTransaction().commit();
//        }
//    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Match match = session.get(Match.class, id);
            if (match != null) {
                session.remove(match);
            }
//            session.remove(id);
//            session.flush();

            session.getTransaction().commit();
        }
    }
}
