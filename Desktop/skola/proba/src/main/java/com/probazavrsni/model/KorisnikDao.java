/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.probazavrsni.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
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
public class KorisnikDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    public List<Korisnik> listaKorisnika() {
        Session session = sessionFactory.getCurrentSession();
        List<Korisnik> lista = session.createCriteria(Korisnik.class).list();
        
        return lista;
        
    }
    
    public void add(Korisnik mar) {
        sessionFactory.getCurrentSession().persist(mar);
    }
    public boolean provera(String username,String password){
        Session s = sessionFactory.getCurrentSession();
        Korisnik k  = (Korisnik) s.createQuery("from Korisnik where username=? and password=? ").setString(0, username).setString(1, password).uniqueResult();
        return k != null;
    }
    
}
