/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mihailo
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
