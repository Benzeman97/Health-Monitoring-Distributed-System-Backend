package com.benz.report.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.report.entity.Report;

@Repository
public interface ReportDAO extends JpaRepository<Report,Integer>{

	
	Report getReportByPatientName(String p_name);
}
