package com.benz.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.benz.user.dao.MemberDAO;
import com.benz.user.entity.Member;
import com.benz.user.exception.DataNotFoundException;
import com.benz.user.services.impl.MemberServiceImpl;

@Service
public class MemberService {
	
	
	@Autowired
	MemberServiceImpl member_service_impl;

	@Autowired
	MemberDAO member_dao;
	
	public Member registration(Member member) throws Exception
	{
            Member mem=  member_service_impl.registration(member);
		return member_dao.save(mem);
		
	}
	public Member updateMember(Member member) 
	{
		Member mem= member_service_impl.updateMember(member);
		return member_dao.save(mem);
	}
	
	public com.benz.user.model.Member getStatus(Member member)
	{
		return member_service_impl.getStatus(member);
	}
	
	public Member getMember(String email)
	{
		Member mem=member_dao.findMemberByEmail(email);
		if(mem!=null)
		return mem;
		else
			throw new DataNotFoundException("Data Not Found");
	}
	public List<Member> getMembers() throws Exception
	{
		return member_dao.findAll();
	}
	
	public void deleteMembers(@PathVariable("email") String email)
	{
		Member mem=member_dao.findMemberByEmail(email);
		if(mem!=null)
			member_dao.delete(mem);  
			else
				throw new DataNotFoundException("Data Not Found");
	}
}
