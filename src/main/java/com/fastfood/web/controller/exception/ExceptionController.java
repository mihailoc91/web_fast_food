/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.controller.exception;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    
    private Log logger = LogFactory.getLog(Exception.class);
    
    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception e){
        logger.error("Request: " + request.getRequestURI() + "raised " + e);
        return "error";
    }
}
