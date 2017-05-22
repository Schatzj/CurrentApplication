package com.schatz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schatz.models.Equipment;
import com.schatz.repository.EqiupmentRepository;

@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	@Autowired
	EqiupmentRepository repository;
	
	public void update(Equipment equipment) {
		repository.save(equipment);
	}

	public void save(Equipment equipment) {
		repository.save(equipment);	
	}
	
	public void delete(long id) {
		repository.delete(id);
	}

	public void delete(Equipment equipment) {
		repository.delete(equipment);
	}

	public List<Equipment> getAllEquipmentForMech(int id) {
		return repository.findAllByMechId(id);
	}

	public Equipment getEquipment(long id) {
		return repository.findById(id);
	}
	
	//probably need to add a string for sheet for some of these. for example 
	//ok wait maybe not. This is database stuff. it does nothing with the spreadsheets. 
	//so 

}
