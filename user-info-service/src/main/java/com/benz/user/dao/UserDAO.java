package com.benz.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.benz.user.entity.User;
import com.benz.user.entity.UserId;

@Component("UserDAO")
public interface UserDAO extends JpaRepository<User,UserId>{

	
	User getUserByUniqueId(String uId);
	User getUserByEmail(String mail);
}
