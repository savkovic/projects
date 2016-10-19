
package com.probazavrsni.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class AutomobilDao {
    
    @Autowired
    SessionFactory sessionFactory;
    
    
    
    public Automobil getById(int id){
          return  (Automobil)sessionFactory.getCurrentSession().get(Automobil.class, id);
    }
    
    public List<Automobil> findByMarka(int id){
        Session session = sessionFactory.getCurrentSession();
        List<Automobil> result = session.getNamedQuery("Automobil.findByMarka").setInteger("marka", id).list();
        
        return result;
    
    } 
    
    public List<Automobil> find(){
        Session session = sessionFactory.getCurrentSession();
        
        List<Automobil> result = session.createCriteria(Automobil.class).list();
        
        return result;
        
    }
     public List<Automobil> findD(int id){
        Session session = sessionFactory.getCurrentSession();
        List<Automobil> result = session.getNamedQuery("from marka").list();
        
        return result;
    
    } 
      public void update(Automobil mar) {
        sessionFactory.getCurrentSession().update(mar);
    }
       public void delete(Automobil mar) {
        sessionFactory.getCurrentSession().delete(mar);
    }
        public void add(Automobil mar) {
        sessionFactory.getCurrentSession().persist(mar);
    }
    
    

}
