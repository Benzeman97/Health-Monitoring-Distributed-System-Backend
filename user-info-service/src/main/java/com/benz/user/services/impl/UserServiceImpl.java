package com.benz.user.services.impl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.benz.user.cfg.UserConfig;
import com.benz.user.dao.UserDAO;
import com.benz.user.entity.User;
import com.benz.user.model.UserLogin;
import com.benz.user.model.UserStatus;

interface IUserServiceImpl
{
	 User updateUser(User user);
	 void checkBMI(double weight,double height);
	 void calculateMaleTDEE(double weight,double height,int age,String active_level);
	 User saveUser(User user);
}

@Service
public class UserServiceImpl implements IUserServiceImpl{

	/*public String randomGenerator()
	{
		Random random=new Random();
		String ran=null;
		for(int i=0;i<2;i++)
		{
			if(ran==null)
			ran=Integer.toString(random.nextInt(1000));
			else
				ran+=Integer.toString(random.nextInt(1000));
		}
		return ran;
	}*/
	
	@Autowired
	UserDAO user_dao=null;
	
	ApplicationContext context=null;
	
	public User updateUser(User user)
	{
		User n_user=user_dao.getUserByUniqueId(user.getUniqueId());
		
		if(n_user!=null) {
		  n_user.setFname(user.getFname());
		  n_user.setLname(user.getLname());
		  n_user.setDistrict(user.getDistrict());
		  n_user.setEmail(user.getEmail());
		  n_user.setPnum(user.getPnum());
		  n_user.setuPassword(user.getuPassword());
		  n_user.setCreated_date(new Date());
		  n_user.setUserType(user.getUserType());
		  
		 return user_dao.save(n_user);
		}else
			return null;
	}
	
	public void checkBMI(double weight,double height)
	{
		double bmi=0.0;
		
		height=height*height;
		
		bmi=weight/height;
		
		//return bmi;TODO
		
	}
	
	public void calculateFemaleTDEE(double weight,double height,int age,String active_level)
	{
		double bmr=0.0;
		
		double a_level;
		
		double tdee;
		
		switch(active_level.toLowerCase())
		{
		case "sedentary" : a_level=1.1;break;
		
		case "lightly active" :a_level=1.275;break;
		
		case "moderately active" :a_level=1.35;break;
		
		case "very active  " :a_level=1.525;break;
		
		default:System.out.println("Invalid");break;
		}
		
		bmr=(height*6.25)+(weight*9.99)-(age*4.92)-161;
		
		//return tdee=bmr*a_level; TODO
	}
	public void calculateMaleTDEE(double weight,double height,int age,String active_level)
	{
		double bmr=0.0;
		
		double a_level;
		
		double tdee;
		
		switch(active_level.toLowerCase())
		{
		case "sedentary" : a_level=1.2;break;
		
		case "lightly active" :a_level=1.375;break;
		
		case "moderately active" :a_level=1.55;break;
		
		case "very active  " :a_level=1.725;break;
		
		default:System.out.println("Invalid");break;
		}
		
		bmr=(height*6.25)+(weight*9.99)-(age*4.92)+5;
		
		//return tdee=bmr*a_level; TODO
	}
	
	public User saveUser(User user)
	{
		try {
			String hash_pawd=BCrypt.hashpw(user.getuPassword(),BCrypt.gensalt(12)); //TODO
			
			user.setuPassword(hash_pawd);
			user.setCreated_date(new Date());
			
			return user_dao.save(user);
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public UserStatus getStatus(UserLogin userLogin)
	{
		User user_=user_dao.getUserByEmail(userLogin.getEmail());
		
		
		if(user_!=null)
		{
			context = new AnnotationConfigApplicationContext(UserConfig.class);
			
			UserStatus userStatus=context.getBean(UserStatus.class);
						
		
			if(user_.getEmail().equals(userLogin.getEmail()) && 
					BCrypt.checkpw(userLogin.getPassword(),user_.getuPassword()))
			{
				
				userStatus.setUserId(user_.getUniqueId());
				userStatus.setLogged(true);
				
				return userStatus;
				
				
			}else {
				userStatus.setUserId("Authentication Failed");
				userStatus.setLogged(false);
				
				return userStatus;
			}
		
		}else
		   return null;
	
	}
			
	
}
