
package com.freelancing.prj.controller;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APiController {
    
        @RequestMapping(value = "/searchhomepage", method = RequestMethod.GET)
        @ResponseBody
	public List<JSONObject> searchHomePage() {
            
            List<JSONObject> jsonList = new ArrayList<JSONObject>();
            
            JSONObject obj=new JSONObject();    
            obj.put("id","6545465");    
            obj.put("gigName","will do java and other programming projects and assignments");    
            obj.put("starting at","$5");            
            jsonList.add(obj);
            
            JSONObject obj2=new JSONObject();    
            obj2.put("id","6545465");    
            obj2.put("gigName","do-java-and-android-programming-for-you");    
            obj2.put("starting at","$5");            
            jsonList.add(obj2);
            
            JSONObject obj3=new JSONObject();    
            obj3.put("id","6545465");    
            obj3.put("gigName","do java programming tasks for web and desktop");    
            obj3.put("starting at","$25");            
            jsonList.add(obj3);
            
            JSONObject obj4=new JSONObject();    
            obj4.put("id","6545465");    
            obj4.put("gigName","do java programming tasks for web and desktop 333");    
            obj4.put("starting at","$15");            
            jsonList.add(obj4);
	  
            System.out.println("jsonList   "+jsonList.toString());
            
	  return jsonList;
	}       
    
    
}
