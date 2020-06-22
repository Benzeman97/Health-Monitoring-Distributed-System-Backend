package com.benz.user.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benz.user.entity.Member;
import com.benz.user.exception.DataNotFoundException;
import com.benz.user.services.MemberService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService member_service;
	 
	@PostMapping("/registration")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Member registration(@RequestBody Member member) throws Exception
	{
		if(!member.getFname().trim().isEmpty() && !member.getEmail().trim().isEmpty() &&
				!member.getPassword().trim().isEmpty() && !member.getDistrict().isEmpty())
			return member_service.registration(member);
		else
			throw new NullPointerException();
	}
	
	@PutMapping("/update")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Member updateMember(@RequestBody Member member)
	{
				  
		if(!member.getFname().trim().isEmpty() && !member.getEmail().trim().isEmpty() &&
				!member.getPassword().trim().isEmpty() && !member.getDistrict().isEmpty())
			return member_service.updateMember(member);
		else
			throw new NullPointerException();
		  
	}
	
	@PostMapping("/login")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public com.benz.user.model.Member getStatus(@RequestBody Member member)
	{
		if(!member.getEmail().trim().isEmpty() && !member.getPassword().trim().isEmpty())
			return member_service.getStatus(member);
		
		else
			throw new NullPointerException();
	}
	

	
	@GetMapping("/{email}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Member getMember(@PathVariable("email") String email)
	{
		if(!email.trim().isEmpty())
			return member_service.getMember(email);
		else
			throw new DataNotFoundException("Data not Available");
			
	}
	
	@GetMapping("/all")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Member> getMembers() throws Exception
	{
		List<Member> members=member_service.getMembers();
		
		if(members.size()!=0)
			return members;
		else
			throw new DataNotFoundException("Data not Available");
		
	}
	
	@DeleteMapping("/delete/{email}")
	public void deleteMembers(@PathVariable("email") String email)
	{
		if(!email.trim().isEmpty())
			member_service.deleteMembers(email);
			else
				throw new DataNotFoundException("Data not Available");
	}
	
	
}
