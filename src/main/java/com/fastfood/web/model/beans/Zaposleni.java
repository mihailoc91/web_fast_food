/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.model.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "zaposleni")
public class Zaposleni implements Serializable {

   
    
    @Id
    @GeneratedValue
    private int id;
    private String ime;
    private String adresa;
    private String telefon;
    private int tip_zaposlenog;
    private int tip_troska;
    private String lozinka;
    
    
    @Override
    public String toString(){
        return "Ime: " + this.getIme()+ " ID: " + this.getId();
    }
    
    
     /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the tip_zaposlenog
     */
    public int getTip_zaposlenog() {
        return tip_zaposlenog;
    }

    /**
     * @param tip_zaposlenog the tip_zaposlenog to set
     */
    public void setTip_zaposlenog(int tip_zaposlenog) {
        this.tip_zaposlenog = tip_zaposlenog;
    }

    /**
     * @return the tip_troska
     */
    public int getTip_troska() {
        return tip_troska;
    }

    /**
     * @param tip_troska the tip_troska to set
     */
    public void setTip_troska(int tip_troska) {
        this.tip_troska = tip_troska;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
