/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.model.dao.impl;

import com.fastfood.web.model.beans.Zaposleni;
import com.fastfood.web.model.dao.ZaposleniDAO;
import java.util.List;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.internal.StoredProcedureQueryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class ZaposleniDAOImpl implements ZaposleniDAO{

    /**
     * Empty constructor.
     */
    public ZaposleniDAOImpl (){
        
    }
    /**
     * Constructor that takes SessionFactory.
     * @param sessionFactory 
     */
    public ZaposleniDAOImpl (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Takes int ID that represent unique ID in table, and returns object of type Zaposleni.class.
     * @param  id - int that represents unique ID in database table
     * @return object of Zaposleni.class
     */
    @Override
    @Transactional
    public Zaposleni getZaposleni(int id) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL get_zaposleni(:id)").addEntity(Zaposleni.class).setParameter("id", id);
        Zaposleni zaposleni = (Zaposleni) query.uniqueResult();
        return zaposleni;
    }

    /**
     * Takes all Zaposleni.class from database and puts them in a List<Zaposleni>.
     * @return List<Zaposleni> filled with objects of type Zaposleni.class
     */
    @Override
    @Transactional
    public List<Zaposleni> getAllZaposleni() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL get_all_zaposleni").addEntity(Zaposleni.class);
        List<Zaposleni> zaposleni = query.list();
        return zaposleni;
    }
    /**
     * Takes object of type Zaposleni.class and updates database.
     * @param zaposleni - instance of Zaposleni.class
     */
    @Override
    @Transactional
    public void updateZaposleni(Zaposleni zaposleni) {
        sessionFactory.getCurrentSession().update(zaposleni);
    }
    
    /**
     * Takes int that represents unique ID of wanted zaposleni in database and deletes it from database.
     * @param id - int that represents unique ID in database
     */
    @Override
    @Transactional
    public void deleteZaposleni(int id) {
        sessionFactory.getCurrentSession().delete(getZaposleni(id));
    }

    /**
     * Takes int that represents column tip_zaposlenog in database and returns a list of zaposleni from that category. 
     * @param id - int that represents type of zaposleni 
     * @return List <Zaposleni> depending on id, if id=2 returns menadzeri or id=2 returns radnci
     */
    @Override
    @Transactional
    public List<Zaposleni> getAllMenadzeriOrRadnici(int id) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL get_all_obj_radnici_or_menadzeri(:id)").addEntity(Zaposleni.class).setParameter("id", id);
        List<Zaposleni> zaposleni = query.list();
        return zaposleni;
   }
    
    /**
     * Takes int that represents column tip_troska in database and returns a list of zaposleni from that category. 
     * @param id - int that represents type of zaposleni 
     * @return List <Zaposleni> depending on id, if id=1 returns stalno zaposleni or id=2 returns zaposleni na odredjeno
     */
    @Override
    @Transactional
    public List<Zaposleni> getAllStalnoZaposleniOrZaposleniNaOdredjeno(int id) {
       Query query = sessionFactory.getCurrentSession().createSQLQuery("CALL get_all_obj_stalno_zap_or_na_ugovor(:id)").addEntity(Zaposleni.class).setParameter("id", id);
        List<Zaposleni> zaposleni = query.list();
        return zaposleni;
    }
    
}
