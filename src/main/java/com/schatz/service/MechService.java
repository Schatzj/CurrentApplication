package com.schatz.service;

import java.util.List;

import com.schatz.models.Mech;

public interface MechService {
	
//	public void test();
	
	public void update(Mech mech);
	
	public void save(Mech mech);
	
	public void delete(int id);
	
	public void delete(Mech mech);
	
	public Mech getMechById(int id);
	
	public List<Mech> getAllMechsByName(String name);
	
	public Mech getOneMechsByName(String name);
	
	public List<Mech> getAllMechs();
	
//	public List<String> getAllMechsByNamesAndId();

}
