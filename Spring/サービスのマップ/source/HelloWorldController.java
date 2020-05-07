package com.pancm.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private static Logger LOG=LoggerFactory.getLogger(HelloWorldController.class);
	
	@Autowired
//	private List<MyService> services;
	private Map<String,Object> services;
	
    @RequestMapping("/hello")
    public String index() {
    	String returnstr="";
    	LOG.info("---------start----------");
//    	for(MyService s:services) {
//    		s.addUser();
//    	}
    	services.get("サービス1").addUser();
    	services.get("サービス2").addUser();
        return returnstr;
    }  
    
}
