package com.schatz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.schatz.service.SheetsIOService;

@RestController
public class MechLabRestController {
	
	@Autowired
	SheetsIOService sheetsService;
	
	@RequestMapping("mechlab/update/{distance}/equipment1/{equipment1}/equipment2/{equipment2}")
	//will the [][][] actually help? maybe research the return type I think it is json. Maybe there is a better way. 
	public List<String> update(@PathVariable("distance")String distance, @PathVariable("equipment1")String equipment1, @PathVariable("equipment2")String equipment2){
		int meters = Integer.valueOf(distance);
		ValueRange equip1 = null;
		ValueRange equip2 = null;
		sheetsService.setDistance(meters);
		//ok so the best way to do this would probably be to have a determinetype method that return an Enum
		//we can then have a switch statement that operates on the Enum.
		if(equipment1.isEmpty() || equipment1.equalsIgnoreCase("null")){
		}else{
			if(sheetsService.isBallistic(equipment1)){
				equip1 = sheetsService.getGunByName(equipment1);
			}
		}
		
		if(equipment2.isEmpty() || equipment2.equalsIgnoreCase("null")){
		}else{
			if(sheetsService.isBallistic(equipment2)){
				equip2 = sheetsService.getGunByName(equipment2);
			}
		}
//		List<String> result = new ArrayList<String>();
		List<List<Object>> temp = equip1.getValues();
		
//		for (List<Object> list : temp) {
//			for (Object object : list) {
//				System.out.println(object);
//			}
//			System.out.println("inner loop end");
//		}
		//need to figure out how to return json or something useful which js can then read and make something useful out of. 
//		System.out.println("distance: " + distance + " equipment1: " + equipment1 + " equpment2: " + equipment2);
		List<String> result = new ArrayList<String>();
		result.add(temp.toString());
		//ok so it returns it so that each row is in [] and values inside the row are comma seperated. That may be sufficient for JS to parse. 
		return result; 
		
//		return null;
	}

}
