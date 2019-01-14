/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *
 * @author Mihailo
 */
public class SpringWebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationConfig = new AnnotationConfigWebApplicationContext();
        applicationConfig.register(ApplicationContextConfig.class);
        
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(applicationConfig));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener(applicationConfig);

        servletContext.addListener(contextLoaderListener);
    }
    
  
    
   
   
}
