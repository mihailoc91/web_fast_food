/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.model.dao;

import com.fastfood.web.model.beans.Zaposleni;
import java.util.List;

/**
 *
 * @author Mihailo
 */
public interface ZaposleniDAO {
    
    /**
     * Takes unique ID and returns instance of Zaposleni.class.
     * @param id - unique ID in database
     * @return instance of Zaposleni.class
     */
    public Zaposleni getZaposleni (int id);
    
    /**
     * Returns a list filled with objects of type Zaposleni.class from database.
     * @return 
     */
    public List <Zaposleni> getAllZaposleni();
    
    /**
     * Takes object of type Zaposleni.class and updates data in database.
     * @param zaposleni object of type Zaposleni.class
     */
    public void updateZaposleni (Zaposleni zaposleni);
    
    /**
     * Takes unique ID and deletes row from database with that ID.
     * @param id - unique ID in database
     */
    public void deleteZaposleni (int id);
    
    /**
     * Return a list of menadzeri or radnici.
     * @param id
     * @return List<Zaposleni> menadzeri (id=2) or List<Zaposleni> radnici (id=1)
     * 
     */
    public List <Zaposleni> getAllMenadzeriOrRadnici(int id);
    
    /**
     * Return a list of stalno zaposleni or zaposleni na odredjeno. 
     * @param id
     * @return List<Zaposleni> stalno zaposleni (id=1) or List<Zaposleni> zaposleni na odredjeno (id=2)
     */
    public List <Zaposleni> getAllStalnoZaposleniOrZaposleniNaOdredjeno(int id);
    
}
