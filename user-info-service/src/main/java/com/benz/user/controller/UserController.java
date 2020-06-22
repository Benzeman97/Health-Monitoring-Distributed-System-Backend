package com.benz.user.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.user.entity.User;
import com.benz.user.model.UserLogin;
import com.benz.user.model.UserStatus;
import com.benz.user.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	
	ApplicationContext context=null;
	
	@Autowired
	UserService user_service=null;

	
	@RequestMapping("/registration")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User registration(@RequestBody User user)
	{
		 
		 
		  if(!user.getUniqueId().trim().isEmpty() && !user.getEmail().trim().isEmpty()
				  && !user.getFname().trim().isEmpty() && !user.getuPassword().trim().isEmpty())
		        return user_service.saveUser(user);
		  else
			  throw new NullPointerException();

		
	}
	

	@PutMapping("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User updateUser(@RequestBody User user)
	{
				  
		  if(!user.getUniqueId().trim().isEmpty())
		    return user = user_service.updateUser(user);
		  else
			  throw new NullPointerException();
		  
	}
	
	@RequestMapping("/login")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public UserStatus getStatus(@RequestBody UserLogin userLogin)
	{
		if(!userLogin.getEmail().trim().isEmpty() && !userLogin.getPassword().trim().isEmpty())
			return user_service.getStatus(userLogin);
			else
				throw new NullPointerException();
	}
	
	
	
}
