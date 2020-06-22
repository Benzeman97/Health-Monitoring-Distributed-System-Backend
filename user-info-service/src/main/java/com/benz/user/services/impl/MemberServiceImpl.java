package com.benz.user.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.benz.user.dao.MemberDAO;
import com.benz.user.entity.Member;


@Service
public class MemberServiceImpl {
	
	@Autowired
	MemberDAO member_dao;


	public Member updateMember(Member member)
	{
		try {
		Member mem=member_dao.findMemberByEmail(member.getEmail());
		if(mem!=null)
		{
			mem.setFname(member.getFname());
			mem.setEmail(mem.getEmail());
			mem.setPassword(member.getPassword());
			mem.setDistrict(mem.getDistrict());
			return mem;
		}else
			return member;
		}catch(NumberFormatException nx)
		{
		nx.printStackTrace();
			 return member;
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return member;
		}
		
				
	}
	
	public com.benz.user.model.Member getStatus(Member member)
	{
		try {
		Member mem=member_dao.findMemberByEmail(member.getEmail());
		
		if(BCrypt.checkpw(member.getPassword(),mem.getPassword()))
			return new com.benz.user.model.Member(mem.getEmail(),true);
		else
			return new com.benz.user.model.Member(member.getEmail(),false);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new com.benz.user.model.Member(member.getEmail(),false);
		}
		
	}
	
	public Member registration(Member member)
	{
		member.setCreated_date(new Date());
		String hashPw=BCrypt.hashpw(member.getPassword(),BCrypt.gensalt(12));
		member.setPassword(hashPw);
		
		return member;
	}
}
