/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.services;

import com.fastfood.web.model.beans.Zaposleni;
import com.fastfood.web.model.dao.ZaposleniDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mihailo
 */
@Service
public class ZaposleniService {
    
    @Autowired
    private ZaposleniDAO zaposleniDao;
    
    
    /**
     * Takes id that represents desirable search of zaposleni.
     * @param id represent desirable search
     * @return Case 1: Returns all zaposleni that are menadzeri <br>
     * Case 2: Returns all zaposleni that are radnici <br>
     * Case 3: Returns all zaposleni that are stalno zaposleni <br>
     * Case 4 Returns all zaposleni that are zaposleni na odredjeno<br>
     * Default: Returns all zaposleni
     */
    public List<Zaposleni> getSelectedZaposleni (int id){
        
        switch(id){
          
            case 1:
                return zaposleniDao.getAllMenadzeriOrRadnici(2);

            case 2:
                return zaposleniDao.getAllMenadzeriOrRadnici(1);

            case 3:
                return zaposleniDao.getAllStalnoZaposleniOrZaposleniNaOdredjeno(1);

            case 4:
                return zaposleniDao.getAllStalnoZaposleniOrZaposleniNaOdredjeno(2);

            default:
                return zaposleniDao.getAllZaposleni();

        }
        
    }
}
