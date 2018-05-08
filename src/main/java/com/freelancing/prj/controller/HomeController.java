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
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController{
    
        @Autowired       
        private SampleComponent sampleComponent ;   
        
        @Autowired
        private EntityManagerFactory emf;

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
           
	return "user2";
	}
       @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("hello");
	  return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

	  ModelAndView model = new ModelAndView();
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}
	
         @RequestMapping(value = { "/role1" }, method = RequestMethod.GET)
	public ModelAndView role1() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is role1 page!");
		model.setViewName("hello");
		return model;
        }
     
        @RequestMapping(value = { "/role2" }, method = RequestMethod.GET)
	public ModelAndView role2() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is role2 page!");
		model.setViewName("hello");
		return model;
        }
        
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
		
	  model.setViewName("403");
	  return model;
	}
        
        
        
        
        
}
