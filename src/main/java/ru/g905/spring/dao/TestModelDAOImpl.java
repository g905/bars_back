/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.dao;

import java.time.Instant;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.g905.spring.model.TestModel;

/**
 *
 * @author zharnikov
 */
@Repository
public class TestModelDAOImpl implements TestModelDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    public List<TestModel> allModels(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TestModel").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }
    
    @Override
    public List<TestModel> allModelsNoPagination() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TestModel").list();
    }

    @Override
    public int getModelsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from TestModel", Number.class).getSingleResult().intValue();
    }

    @Override
    public void add(TestModel tm) {
        Session session = sessionFactory.getCurrentSession();
        Date date = new Date();
        tm.setCreated_at(date.getTime());
        tm.setUpdated_at(tm.getCreated_at());
        session.persist(tm);
    }

    @Override
    public void delete(TestModel tm) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tm);
    }

    @Override
    public void edit(TestModel tm) {
        Session session = sessionFactory.getCurrentSession();
        Date date = new Date();
        tm.setUpdated_at(date.getTime());
        session.update(tm);
    }

    @Override
    public TestModel getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(TestModel.class, id);
    }

}
