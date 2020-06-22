package com.benz.doctor.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.doctor.entity.DocId;
import com.benz.doctor.entity.Doctor;

@Repository
public interface DoctorDAO extends JpaRepository<Doctor,DocId>{

	Doctor findBySlmcRegNo(String regNo);
	
	Doctor findBydocName(String name);
	
	List<Doctor> findBySpecialization(String specialization);
}
