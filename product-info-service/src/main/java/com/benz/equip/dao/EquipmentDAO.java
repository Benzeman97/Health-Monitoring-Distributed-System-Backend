package com.benz.equip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benz.equip.entity.Equipment;

@Repository
public interface EquipmentDAO extends JpaRepository<Equipment,Integer>{

}
