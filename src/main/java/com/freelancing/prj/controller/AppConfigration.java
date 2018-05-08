package com.freelancing.prj.controller;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableJpaRepositories
@EnableTransactionManagement
@Import({ SecurityConfig.class })
@ComponentScan(basePackages = 
        {"com.freelancing.prj.controller","com.freelancing.prj.component",
            "com.freelancing.prj.persistance","com.freelancing.prj.repositories"})
public class AppConfigration {    
    @Bean
    public DataSource getDataSource() {        
        System.out.println("line 25");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
         System.out.println("line 26");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         System.out.println("line 27");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/freelancing?useSSL=true");
         System.out.println("line 28");
        dataSource.setUsername("root");
         System.out.println("line 28");
        dataSource.setPassword("");         
        return dataSource;
    }
    
    @Bean
    public ViewResolver getViewResolver() {        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public JpaTransactionManager jpaTransactionManager() throws ClassNotFoundException {
        System.out.println("line 45");    
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }     
    
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        System.out.println("line 64");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
          System.out.println("line 66");
        entityManagerFactoryBean.setDataSource(getDataSource());
          System.out.println("line 68");
        HibernateJpaVendorAdapter h = new HibernateJpaVendorAdapter();
          System.out.println("line 70");
        entityManagerFactoryBean.setJpaVendorAdapter(h);        
          System.out.println("line 72");
        entityManagerFactoryBean.setPackagesToScan(new String []{"com.freelancing.prj.controller",
            "com.freelancing.prj.component","com.freelancing.prj.persistance","com.freelancing.prj.repositories"});
          System.out.println("line 74");
        Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            jpaProperties.put("hibernate.hbm2ddl.auto", "Validate");
            jpaProperties.put("hibernate.show_sql", "true");
            jpaProperties.put("hibernate.format_sql", "true");    
          entityManagerFactoryBean.setJpaProperties(jpaProperties);
          System.out.println("line 81");
        return entityManagerFactoryBean;
     }  

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf,DataSource dataSource){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
        jpaTransactionManager.setDataSource(dataSource);
        return jpaTransactionManager;
    }  
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer(){
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }    	
}


