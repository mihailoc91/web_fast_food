/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.controller;

import com.fastfood.web.model.beans.Zaposleni;
import com.fastfood.web.model.dao.ZaposleniDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mihailo
 */
@Controller
public class WelcomeController {
    
    @Autowired
    ZaposleniDAO zaposleniDao;
    
    
    /**
     * Returns index page.
     * @param model ModelMap
     * @return page index
     */
    @RequestMapping("/")
    public String welcome(ModelMap model){
        Zaposleni zaposleni = zaposleniDao.getZaposleni(1);
        model.addAttribute("zaposleni",zaposleni);
        return "index";
    }
    
    
}
