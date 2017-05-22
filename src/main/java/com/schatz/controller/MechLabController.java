package com.schatz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.schatz.models.Mech;
import com.schatz.service.EquipmentService;
import com.schatz.service.MechService;
import com.schatz.service.SheetsIOService;

@Controller
public class MechLabController {
	
	@Autowired
	MechService service;
	
	@Autowired
	SheetsIOService sheetsService;
	
	@RequestMapping(value = {"MechLab"})
	public String home(Model model) {
		List<String> ballistics = sheetsService.getAllMechBallisticsAsList();
//		String[][] ball = sheetsService.getAllMechBallistics();
//		for(int i = 0; i<ball.length; i++){
//			for(int j = 0; j<ball[i].length; j++){
//				System.out.println("ball is: " + ball[i][j] + " i and j " + i + " " + j);
//			}
//		}
		List<Mech> mechs = service.getAllMechs();
		model.addAttribute("Mechs", mechs);
		model.addAttribute("Ballistics", ballistics);
		
//		sheetsService.getGunByName("foo");
		
		return "home/MechLab";
	}

}
