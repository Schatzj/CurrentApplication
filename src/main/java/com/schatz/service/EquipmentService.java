package com.schatz.service;

import java.util.List;

import com.schatz.models.Equipment;

public interface EquipmentService {
	
	public void update(Equipment equipment);
	public void save(Equipment equipment);
	public void delete(long id);
	public void delete(Equipment equipment);
	
	public List<Equipment> getAllEquipmentForMech(int id);
	public Equipment getEquipment(long id);

}
