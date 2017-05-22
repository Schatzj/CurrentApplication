package com.schatz.service;

import java.util.List;

import com.google.api.services.sheets.v4.model.ValueRange;

public interface SheetsIOService {

//	public void test();
	public String[][] getAllMechBallistics();
	public List<String> getAllMechBallisticsAsList();
	public String getDistance();
	public void setDistance(int value); 
	public ValueRange getGun(int startCell);
	public double getGunWeight(int startCell);
	public int getGunstartCell(String gunName);
	public boolean isBallistic(String name);
	public ValueRange getGunByName(String name);

}