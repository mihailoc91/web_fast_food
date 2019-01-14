/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.controller.zaposleni;

import com.fastfood.web.model.beans.Zaposleni;
import com.fastfood.web.model.dao.ZaposleniDAO;
import com.fastfood.web.services.ZaposleniService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ZaposleniController {
    
    @Autowired
    ZaposleniDAO zaposleniDao;
    
    @Autowired
    ZaposleniService zaposleniService;
    
    /**
     * Takes ModelMap and Integer id which is not required, depending on users choice shows all zaposleni or specific type of zaposleni.
     * @param model ModelMap
     * @param id - Integer that represent desirable search of zaposlni
     * @return page zaposleni
     */
   
    @RequestMapping("/zaposleni")
    public String zaposleni(ModelMap model, @RequestParam(required = false) Integer id){
       List<Zaposleni> zaposleni = id==null? zaposleniService.getSelectedZaposleni(0):zaposleniService.getSelectedZaposleni(id);
        model.addAttribute("zaposleni", zaposleni);
        model.addAttribute("id", id);
        return "zaposleni";
    }
    
    /**
     * Takes id of chosen Zaposleni.class to update, loads object of type  Zaposleni.class with that id from database
     * and enables user to edit data on that object.<br>
     * After user finish with editing of data on that object, forwards the edited object of zaposleni using ModelMap model to method updateZaposleni() which accepts RequestMethod.POST.
     * @param model ModelMap
     * @param id - the id of chosen Zaposleni
     * @return page zaposleni/update
     */
    @RequestMapping(value = "/zaposleni/update" , method = RequestMethod.GET)
    public String updateZaposleni(ModelMap model, @RequestParam int id ){
        Zaposleni zaposleni = zaposleniDao.getZaposleni(id);
        model.addAttribute("zaposleni", zaposleni);
        return "zaposleni/update";
    }
    
    /**
     * Takes object of type Zaposleni.class, validates all properties of that object.<br>
     * If validation fails returns the user to the same page to edit object again.<br>
     * If validation is successful, updates the database, clears model and redirects user to zaposleni page. 
     * @param model ModelMap
     * @param zaposleni - object of type Zaposleni.class 
     * @param result BindingResult
     * @return page zaposleni
     */
    @RequestMapping(value = "/zaposleni/update", method = RequestMethod.POST)
    public String updateZaposleni(ModelMap model, @Valid Zaposleni zaposleni, BindingResult result){
        if(result.hasErrors()){
            return "zaposleni/update";
        }
        zaposleniDao.updateZaposleni(zaposleni);
        
        model.clear();
        
     return "redirect: ../zaposleni";   
    }
    
    /**
     * Takes id of chosen Zaposleni.class, removes it from database, clears model and redirects user to page zaposleni.
     * @param model ModelMap
     * @param id - id of chosen Zaposleni.class 
     * @return page zaposleni
     */
    @RequestMapping (value = "/zaposleni/delete", method = RequestMethod.GET)
    public String deleteZaposleni(ModelMap model, @RequestParam int id ){
        zaposleniDao.deleteZaposleni(id);
        model.clear();
       
        return "redirect: ../zaposleni";
    }
}
