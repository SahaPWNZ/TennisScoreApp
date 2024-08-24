package com.sahapwnz.tennisscoreapp.dao;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.exceptions.DataBaseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class MatchDAO extends BaseDAO<Match> {
    private final int PAGE_SIZE = 4;
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
        catch (HibernateException e){
            System.out.println(e.getMessage());
                throw new DataBaseException("Error when working with a database");
            }
    }

    @Override
    public Optional<Match> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Match.class, id));
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }
    public List<Match> findAllByPlayerName(String name, int pageNumber){
        int offSet = (pageNumber -1)* PAGE_SIZE;

        try(Session session = sessionFactory.openSession()){
            Query<Match> query = session.createQuery
                    ("select m from Match m where m.player1.name = :firstName or m.player2.name=:secondName", Match.class);
            query.setParameter("firstName", name);
            query.setParameter("secondName", name);
            query.setMaxResults(PAGE_SIZE);
            query.setFirstResult(offSet);
            return query.list();
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
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
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }
    public List<Match> findAllMatchesForPagination (int pageNumber){
        int offSet = (pageNumber -1)* PAGE_SIZE;

        try(Session session = sessionFactory.openSession()){
            Query<Match> query = session.createQuery
                    ("select m from Match m", Match.class);
            query.setMaxResults(PAGE_SIZE);
            query.setFirstResult(offSet);
            return query.list();
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
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
        catch (HibernateException e){
            System.out.println(e.getMessage());
            throw new DataBaseException("Error when working with a database");
        }
    }


    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Match match = session.get(Match.class, id);
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
