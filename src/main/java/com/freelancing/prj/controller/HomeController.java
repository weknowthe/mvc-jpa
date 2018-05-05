package com.freelancing.prj.controller;

import com.freelancing.prj.component.SampleComponent;
import com.freelancing.prj.component.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.freelancing.prj.persistance.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import com.freelancing.prj.component.UserRepositoryQ;


@Controller
public class HomeController{
    
        @Autowired       
        private SampleComponent sampleComponent ;   
        
        @Autowired
        private EntityManagerFactory emf;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {

               // logger.info("In scope");            
		model.addAttribute("userName", "testUser");                
		return "user";
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test( Model model) {
 
                //logger.info("In scope test1");
		model.addAttribute("userName", "testUser1");
		return "user";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2( Model model) {

            EntityManager em = emf.createEntityManager();
            User u = (User)em.createNativeQuery("Select * from user", User.class).getResultList().get(0);
            System.out.println("user"+u.toString());
            
		model.addAttribute("userName", "testUser2");
		return "user2";
	}
        
        @RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3( Model model) {
            
                   
        System.out.println("user"+sampleComponent.testValue());
	//model.addAttribute("userName", user.getUserName());
           
	return "user2";
	}

}
