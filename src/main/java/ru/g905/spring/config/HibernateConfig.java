/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.spring.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author zharnikov
 */
@Configuration
@ComponentScan(basePackages = "ru.g905")
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        props.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        return props;
    }

    @Bean
    public DataSource dataSrc() {
        BasicDataSource dataSrc = new BasicDataSource();
        dataSrc.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSrc.setUrl(env.getRequiredProperty("jdbc.url"));
        //dataSrc.setUsername(env.getRequiredProperty("jdbc.username"));
        //dataSrc.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSrc;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(dataSrc());
        sf.setPackagesToScan("ru.g905");
        sf.setHibernateProperties(hibernateProperties());
        return sf;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        SessionFactory lsfb = sessionFactory().getObject();
        transactionManager.setSessionFactory(lsfb);
        return transactionManager;
    }

}
