/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.probazavrsni.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dusan Savkovic
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class MarkaDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public List<Marka> find() {
        Session session = sessionFactory.getCurrentSession();
        List<Marka> result = session.createCriteria(Marka.class).list();
        
        return result;
        
    }
    
    public Marka getById(int id) {
        return (Marka) sessionFactory.getCurrentSession().get(Marka.class, id);
    }
    
    public void update(Marka mar) {
        sessionFactory.getCurrentSession().update(mar);
    }
    
    public void delete(Marka mar) {
        sessionFactory.getCurrentSession().delete(mar);
    }
    
    public void save(Marka mar) {
        sessionFactory.getCurrentSession().save(mar);
    }
    
    public void add(Marka marka) {
        sessionFactory.getCurrentSession().persist(marka);
    }
}
