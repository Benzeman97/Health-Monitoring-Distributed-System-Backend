package com.benz.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.user.entity.Member;

@Repository
public interface MemberDAO extends JpaRepository<Member,Integer>{

	Member findMemberByEmail(String email);
}
