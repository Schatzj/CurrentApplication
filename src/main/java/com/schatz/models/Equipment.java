package com.schatz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="equipment", schema="battle-tech")
public  class Equipment {
	@NotNull
	@Id
	private long id; //primary key
	@Column(name = "mech_id")
	private int mechid; //foreign key	
	private String pillar;
	private int row;
	private String sheet;
	private String location;
	private double weight;
	private int ammo;
	private String mod1;
	private String mod2;
	private String mod3; 
	private String mod4;
	private String mod5;
	private String mod6;
	private String mod7;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getMechid() {
		return mechid;
	}
	public void setMechid(int mechid) {
		this.mechid = mechid;
	}
	public String getColumn() {
		return pillar;
	}
	public void setColumn(String column) {
		this.pillar = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getSheet() {
		return sheet;
	}
	public void setSheet(String sheet) {
		this.sheet = sheet;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAmmo() {
		return ammo;
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	public String getMod1() {
		return mod1;
	}
	public void setMod1(String mod1) {
		this.mod1 = mod1;
	}
	public String getMod2() {
		return mod2;
	}
	public void setMod2(String mod2) {
		this.mod2 = mod2;
	}
	public String getMod3() {
		return mod3;
	}
	public void setMod3(String mod3) {
		this.mod3 = mod3;
	}
	public String getMod4() {
		return mod4;
	}
	public void setMod4(String mod4) {
		this.mod4 = mod4;
	}
	public String getMod5() {
		return mod5;
	}
	public void setMod5(String mod5) {
		this.mod5 = mod5;
	}
	public String getMod6() {
		return mod6;
	}
	public void setMod6(String mod6) {
		this.mod6 = mod6;
	}
	public String getMod7() {
		return mod7;
	}
	public void setMod7(String mod7) {
		this.mod7 = mod7;
	}
}
