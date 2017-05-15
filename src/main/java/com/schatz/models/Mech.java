package com.schatz.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mech", schema="battle-tech")
public class Mech {
	@NotNull
	@Id
	private int mech_id;
	private String mech_name;
	private int RLFArmour;
	private int RLBArmour;
	private int LLFArmour;
	private int LLBArmour;
	private int CTFArmour;
	private int CTBArmour;
	private int RSFArmour;
	private int RSBArmour;
	private int LSFArmour;
	private int LSBArmour;
	private int RAFArmour;
	private int RABArmour;
	private int LAFArmour;
	private int LABArmour;
	
	public int getMech_id() {
		return mech_id;
	}
	public void setMech_id(int mech_id) {
		this.mech_id = mech_id;
	}
	public String getMech_name() {
		return mech_name;
	}
	public void setMech_name(String mech_name) {
		this.mech_name = mech_name;
	}
	public int getRLFArmour() {
		return RLFArmour;
	}
	public void setRLFArmour(int rLFArmour) {
		RLFArmour = rLFArmour;
	}
	public int getRLBArmour() {
		return RLBArmour;
	}
	public void setRLBArmour(int rLBArmour) {
		RLBArmour = rLBArmour;
	}
	public int getLLFArmour() {
		return LLFArmour;
	}
	public void setLLFArmour(int lLFArmour) {
		LLFArmour = lLFArmour;
	}
	public int getLLBArmour() {
		return LLBArmour;
	}
	public void setLLBArmour(int lLBArmour) {
		LLBArmour = lLBArmour;
	}
	public int getCTFArmour() {
		return CTFArmour;
	}
	public void setCTFArmour(int cTFArmour) {
		CTFArmour = cTFArmour;
	}
	public int getCTBArmour() {
		return CTBArmour;
	}
	public void setCTBArmour(int cTBArmour) {
		CTBArmour = cTBArmour;
	}
	public int getRSFArmour() {
		return RSFArmour;
	}
	public void setRSFArmour(int rSFArmour) {
		RSFArmour = rSFArmour;
	}
	public int getRSBArmour() {
		return RSBArmour;
	}
	public void setRSBArmour(int rSBArmour) {
		RSBArmour = rSBArmour;
	}
	public int getLSFArmour() {
		return LSFArmour;
	}
	public void setLSFArmour(int lSFArmour) {
		LSFArmour = lSFArmour;
	}
	public int getLSBArmour() {
		return LSBArmour;
	}
	public void setLSBArmour(int lSBArmour) {
		LSBArmour = lSBArmour;
	}
	public int getRAFArmour() {
		return RAFArmour;
	}
	public void setRAFArmour(int rAFArmour) {
		RAFArmour = rAFArmour;
	}
	public int getRABArmour() {
		return RABArmour;
	}
	public void setRABArmour(int rABArmour) {
		RABArmour = rABArmour;
	}
	public int getLAFArmour() {
		return LAFArmour;
	}
	public void setLAFArmour(int lAFArmour) {
		LAFArmour = lAFArmour;
	}
	public int getLABArmour() {
		return LABArmour;
	}
	public void setLABArmour(int lABArmour) {
		LABArmour = lABArmour;
	}
}
