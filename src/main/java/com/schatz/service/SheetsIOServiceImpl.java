package com.schatz.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ValueRange;

@PropertySource("classpath:application.properties")
@Service
public class SheetsIOServiceImpl implements SheetsIOService {
	
	@Autowired
	private SheetsService service;
	
	@Value("${sheets.id.string}")
	private String id;
	
	private String[][] allBallisticsByName = null;

	/**
	 * returns a 2d string array. Where the first array contains an array for each gun
	 *the second array contains the cell number of the gun, and the gun name. 
	 *So [0][0] = 7
	 *and [0][1] = c-ac20
	 *and [1]... contains info for C-ac10. 
	 */
	public String[][] getAllMechBallistics() {
		if (allBallisticsByName == null) {
			try {
				Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
				ValueRange response = sheet.values().get(id, "Weapons!A1:A250").execute();

				List<List<Object>> input = response.getValues();

				String[][] guns = new String[(input.size() / 4) + 1][2];
				int index = 0;
				for (int i = 6; i < input.size(); i = i + 4) {
					Integer cell = i + 1;
					guns[index][0] = cell.toString();
					guns[index][1] = input.get(i).get(0).toString();
					index = index + 1;
					if (i == 74) {
						i = 76;
					}
				}
				allBallisticsByName = guns;

			} catch (IOException ioe) {
				System.out.println("Something went wrong io " + ioe);
				return null;
			} catch (Exception e) {
				System.out.println("something went wrong maybe credentials? " + e);
				return null;
			}
		}
		return allBallisticsByName;
	}

	public String getDistance() {
		String result = "ERROR";
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			ValueRange response = sheet.values().get(id, "Weapons!A3").execute();
			result = response.getValues().get(0).get(0).toString();
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
			result = "ERROR";
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
			result = "ERROR";
		}
		return result;
	}

	public void setDistance(int value) {
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			
			ValueRange valuesToEnter = new ValueRange();
			List<List<Object>> actualValues = new ArrayList<List<Object>>();
			List<Object> theValues = new ArrayList<Object>();
			theValues.add(value);
			actualValues.add(theValues);
			valuesToEnter.setValues(actualValues);
			ValueRange vr = new ValueRange().setValues(actualValues);
			sheet.values().update(id, "Weapons!A3", vr).setValueInputOption("USER_ENTERED").execute(); //USER_ENTERED and RAW are the two values			
//			sheet.values().update(id, "Weapons!A3?valueInputOption=USER_ENTERED", valuesToEnter);
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
		}
	}

	public ValueRange getGun(int startCell) {
		//the start cell is the guns name. We then need the next two rows and all the columns to L
		String range = "Weapons!A" + startCell +":L"+ (startCell+3); //plus three so we pick up the mod values. 
		ValueRange result;
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			result = sheet.values().get(id, range).execute();
//			result.setMajorDimension(majorDimension)
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
			result =  null;
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
			result = null;
		}
		return result;
	}

	public double getGunWeight(int startCell) {
		//start cell is the Row Number and is. Weight is in Column H
		//since we assume start cell is the Name of the gun we need to add two to it. 
		double result;
		startCell = startCell + 2;
		String range = "Weapons!H" + startCell;
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			ValueRange response = sheet.values().get(id, range).execute();
			String tempResult = response.getValues().get(0).get(0).toString();
			 result= Double.valueOf(tempResult);
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
			result =  -1;
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
			result = -1;
		}
		return result;
	}

	public boolean isBallistic(String name){
		if(allBallisticsByName == null){
			getAllMechBallistics();
		}
		for(int i = 0; i<allBallisticsByName.length; i++){
			for(int j = 1; j<allBallisticsByName[i].length; j++){
				if(allBallisticsByName[i][j].equalsIgnoreCase(name)){
					return true;
				}
			}
		}
		return false;
	}

	public int getGunstartCell(String gunName) {
		if(allBallisticsByName == null){
			getAllMechBallistics();
		}
		for(int i = 0; i<allBallisticsByName.length; i++){
			for(int j = 1; j<allBallisticsByName[i].length; j++){
				if(allBallisticsByName[i][j].equalsIgnoreCase(gunName)){
					return Integer.valueOf(allBallisticsByName[i][j-1]);
				}
			}
		}
		return -1;
	}

	public ValueRange getGunByName(String name) {
		return getGun(getGunstartCell(name));
	}

	public List<String> getAllMechBallisticsAsList() {
		List<String> allBallistics = new ArrayList<String>();
		if(allBallisticsByName == null){
			getAllMechBallistics();
		}
		for(int i = 0; i<allBallisticsByName.length; i++){
			for(int j = 1; j<allBallisticsByName[i].length; j++){
				allBallistics.add(allBallisticsByName[i][j]);
			}
		}
		return allBallistics;
	}

}
