package com.benz.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.benz.user.entity.User;
import com.benz.user.exception.DataNotFoundException;
import com.benz.user.model.UserLogin;
import com.benz.user.model.UserStatus;
import com.benz.user.services.impl.UserServiceImpl;

@Service
public class UserService {

	@Autowired
	UserServiceImpl user_service_impl=null;
	
	public User saveUser(User user)
	{
		
	  return user_service_impl.saveUser(user);
	
	}
	
	public User updateUser(User user)
	{
		
		User user_=user_service_impl.updateUser(user);
		
		if(user_!=null)
			return user_;
		else
			throw new DataNotFoundException("Data Not Available For "+user.getUniqueId());
	}
	
	public UserStatus getStatus(UserLogin userLogin)
	{
		UserStatus userStatus=user_service_impl.getStatus(userLogin);
		
	   if(userStatus!=null)
		   return userStatus;
	   else
		   throw new DataNotFoundException("Data Not Available For "+userLogin.getEmail());
	}
}
