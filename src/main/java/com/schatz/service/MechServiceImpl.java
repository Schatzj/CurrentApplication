package com.schatz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schatz.models.Mech;
import com.schatz.repository.MechRepository;

@Service
public class MechServiceImpl implements MechService{

	@Autowired
	MechRepository repository;
	
//	public void test(){
//		int id = 1;
//		Mech mech = repository.findByid(id);
//		System.out.println("mech is: " + mech);
//		System.out.println("mech name is: " + mech.getMech_name());
//	}

	public void update(Mech mech) {
		repository.save(mech);
	}

	public void save(Mech mech) {
		repository.save(mech);	
	}
	
	public void delete(int id) {
		repository.delete(id);
	}

	public void delete(Mech mech) {
		repository.delete(mech);
	}

	public Mech getMechById(int id) {
		return repository.findByid(id);
	}

//	public List<Mech> getMechByName(String name) {
//		return repository.findByname(name);
//	}

	public List<String> getAllMechsNamesAndId() {
		return null;
	}

	public List<Mech> getAllMechsByName(String name) {
		return repository.findByname(name);
	}

	public Mech getOneMechsByName(String name) {
		List<Mech> findByname = repository.findByname(name);
		return findByname.get(0);
	}

	public List<Mech> getAllMechs() {
		return repository.getAllMechs();
	}

//	public List<String> getAllMechsByNamesAndId() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
