package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.entity.Player;
import com.sahapwnz.tennisscoreapp.exceptions.DataBaseException;
import org.hibernate.HibernateException;
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
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }

    @Override
    public Optional<Player> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Player.class, id));
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }

    public Optional<Player> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {

            return Optional.ofNullable(session.createQuery("select p from Player p where p.name =:name", Player.class)
                    .setParameter("name", name)
                    .uniqueResult());
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
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
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }


    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Player match = session.get(Player.class, id);
            if (match != null) {
                session.remove(match);
            }

            session.getTransaction().commit();
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }
}
