package com.benz.hospital.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.hospital.entity.Hospital;

@Repository
public interface HospitalDAO extends JpaRepository<Hospital,String>{

	Hospital findByHospitalName(String hospitalName);
	
}
