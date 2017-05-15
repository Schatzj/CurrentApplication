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
	
	/* (non-Javadoc)
	 * @see com.schatz.service.SheetsIOService#test()
	 */
	public void test(){
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			ValueRange response = sheet.values().get(id, "A1").execute();
			
//			System.out.println("the response is: " + response.toPrettyString());
		
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
		}
	}

	public String[][] getAllMechBallistics() {
//		List<List<String>>result = new ArrayList<String>(); 
		
		try{
			Sheets.Spreadsheets sheet = service.getSheetsService().spreadsheets();
			ValueRange response = sheet.values().get(id, "Weapons!A1:A250").execute();
			
			List<List<Object>> input = response.getValues();
			
			String[][] guns = new String[(input.size()/4) + 1][2];
			
//			for(int i = 0; i<input.size(); i++){
//				for(int j = 0; j<input.get(i).size(); j++){
//					System.out.println("[" + i +"]" + "[" + j + "] " + input.get(i).get(j));
//				}
//			}
			
//			System.out.println("guns.size is: " + guns.length);
			int index = 0;
			for(int i = 6; i<input.size(); i=i+4){
//				System.out.println("index is: " + i);
				Integer cell = i + 1;
				guns[index][0] = cell.toString();
				guns[index][1] = input.get(i).get(0).toString();
				index = index + 1;
				if(i == 74){
					i = 76;
				}
			}
			
//			System.out.println("*******************************************");
//			for(int i = 0; i<guns.length; i++){
//				System.out.println(guns[i][0]);
//				System.out.println(guns[i][1]);
//			}
			return guns;
			
		}catch(IOException ioe){
			System.out.println("Something went wrong io " + ioe);
		}catch(Exception e){
			System.out.println("something went wrong maybe credentials? " + e);
		}
		return null;
		
//		return guns;
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

	public List<String> getAllMechBallisticsAsList() {
		List<String>result = new ArrayList<String>();
		String[][] allMechBallistics = getAllMechBallistics();
		for(int i = 0; i<allMechBallistics.length; i++){
			result.add(allMechBallistics[i][1]);
		}
		return result;
	}

}
