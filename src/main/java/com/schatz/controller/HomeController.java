package com.schatz.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.schatz.models.Equipment;
import com.schatz.models.Mech;
import com.schatz.service.EquipmentService;
import com.schatz.service.MechService;
import com.schatz.service.SheetsIOService;

@Controller
public class HomeController {
	
	@Autowired
	SheetsIOService sheetsio;
	
	@Autowired
	MechService service;
	
	@Autowired
	EquipmentService equipmentService;
	
	@RequestMapping(value = {"/", "home", "index"})
	public String home() {
//		List<Mech> allMechs = service.getAllMechs();
//		for(int i = 0; i<allMechs.size(); i++){
//			System.out.println(allMechs.get(i).getMech_name() + " " + allMechs.get(i).getMech_id());
//		}
//		Mech mech1 = new Mech();
//		mech1.setMech_name("Jamie");
//		mech1.setMech_id(4);
//		Mech mech2 = new Mech();
//		mech2.setMech_name("Jamie");
//		mech2.setMech_id(5);
//		service.save(mech1);
//		service.save(mech2);
//		List<Mech> allMechsByName = service.getAllMechsByName("Jamie");
//		for(int i = 0; i<allMechsByName.size(); i++){
//			System.out.println(allMechsByName.get(i).getMech_name() + " " + allMechsByName.get(i).getMech_id());
//		}
//		Mech oneMechsByName = service.getOneMechsByName("Jamie");
//		System.out.println("*****************************************");
//		System.out.println(oneMechsByName.getMech_name() + " " + oneMechsByName.getMech_id());
		
//		sheetsio.getAllMechBallistics();
//		System.out.println(sheetsio.getDistance());
//		sheetsio.setDistance(500);
//		System.out.println(sheetsio.getDistance());
//		System.out.println("the weight of AC10: " + sheetsio.getGunWeight(11));
//		try{
//			ValueRange gun = sheetsio.getGun(7);
//			System.out.println(gun.toPrettyString());
//		}catch(IOException ioe){
//			System.out.println("IOE: " + ioe);
//		}
//		sheetsio.test();
////		service.test();
//		Mech mech1 = new Mech();
//		mech1.setMech_id(1);
//		mech1.setMech_name("Test");
//		Mech mech = new Mech();
//		mech.setMech_id(2);
//		mech.setMech_name("Tyrion");
//		mech.setRLFArmour(15);
//		service.save(mech);
//		Equipment equipment= new Equipment();
//		equipment.setId(12);
//		equipment.setMechid(2);
//		equipment.setSheet("test");
//		equipmentService.save(equipment);
//		Equipment equipment2 = new Equipment();
//		equipment2.setId(2);
//		equipment2.setMechid(2);
//		equipment2.setSheet("test");
//		equipment2.setAmmo(50);
//		equipmentService.save(equipment2);
//		Equipment equipment3 = new Equipment();
//		equipment3.setId(3);
//		equipment3.setMechid(1);
//		equipment3.setSheet("test");
//		equipment3.setAmmo(60);
//		equipmentService.save(equipment3);
//		List<Equipment> weapons = equipmentService.getAllEquipmentForMech(2);
//		System.out.println("the list of all weapons is of length: " +  weapons.size());
//		for(int i = 0; i<weapons.size(); i++){
//			System.out.println(weapons.get(i).getSheet() + " " + weapons.get(i).getAmmo());
//		}
//		
//		Mech retrievedMech = service.getMechById(2);
//		System.out.println("the retrievedMech is: " + retrievedMech.getRLFArmour() + " " + retrievedMech.getMech_name());
		return "home/index";
	}

}
