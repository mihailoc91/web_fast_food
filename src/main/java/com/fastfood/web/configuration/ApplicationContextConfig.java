/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastfood.web.configuration;

import com.fastfood.web.model.beans.Zaposleni;
import com.fastfood.web.model.dao.ZaposleniDAO;
import com.fastfood.web.model.dao.impl.ZaposleniDAOImpl;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Mihailo
 */
@Configuration
@ComponentScan(basePackages = "com.fastfood.web")
@EnableTransactionManagement
@EnableWebMvc
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {
    
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/resources/").addResourceLocations("/WEB-INF/views/resources/css/")
                .addResourceLocations("/WEB-INF/views/resources/js/").addResourceLocations("/WEB-INF/views/resources/img/");
    }
    
    @Bean(name = "dataSource")
    public DataSource getDataSource (){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/fast_food");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
        
    }
    
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory (DataSource dataSource){
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        /* Ovde idu klase koje hocu da mapiram*/
        sessionBuilder.addAnnotatedClass(Zaposleni.class);
        //Ovde isto idu i podesavanja hibernate-a
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }
    
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager (SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
    
    /*
    Ovako dajem sessionFactory implementaciji
    @Autowired
    @Bean(name="korisniciDao")
    public KorisniciDAO getKorisniciDao(SessionFactory sessionFactory){
        return new KorisniciDAOImpl(sessionFactory);
    }
    */
    
    /**
     * Hibernate properties.
     */
    private Properties getHibernateProperties (){
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }
    
    /**
     * Autowiring implementation of interface ZaposleniDAO as class ZaposleniDAOImpl.
     * @param sessionFactory
     * @return object ZaposleniDAOImpl
     */
    @Autowired
    @Bean(name = "zaposleniDao")
    public ZaposleniDAO getZaposleniDao (SessionFactory sessionFactory){
        return new ZaposleniDAOImpl (sessionFactory);
    }
    
  
    
}
