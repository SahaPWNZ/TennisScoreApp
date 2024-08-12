package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class PlayerDAO extends BaseDAO<Player> {
    public PlayerDAO() {
        super();
    }

    public PlayerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Player> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select p from Player p", Player.class).list();

        }
    }

    @Override
    public Optional<Player> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Player.class, id));
        }
    }

    public Optional<Player> findByName(String name){
        try(Session session = sessionFactory.openSession()){

            return Optional.ofNullable(session.createQuery("select p from Player p where p.name =:name", Player.class)
                    .setParameter("name", name)
                    .uniqueResult());
        }
    }

    @Override
    public Player save(Player entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(entity);

            session.getTransaction().commit();

            return entity;
        }
    }

//    @Override
//    public void update(Player entity) {
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

            Player match = session.get(Player.class, id);
            if (match != null) {
                session.remove(match);
            }
//            session.remove(id);
//            session.flush();

            session.getTransaction().commit();
        }
    }
}
