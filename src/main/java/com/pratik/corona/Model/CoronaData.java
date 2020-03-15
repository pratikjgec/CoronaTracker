package com.pratik.corona.Model;

import java.util.Date;

public class CoronaData {
	
	private String state;
	private String country;
	private int latestTotalCases;
	private int deaths;
	private int recoverd;
	private Date date;
	
	
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int record) {
		this.deaths = record;
	}
	public int getRecoverd() {
		return recoverd;
	}
	public void setRecoverd(int recoverd) {
		this.recoverd = recoverd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(int record) {
		this.latestTotalCases = record;
	}
	
	@Override
	public String toString() {
		return "Coronadate [state=" + state + ", country=" + country + ", latestTotalCases=" + latestTotalCases + "]";
	}
	
	
	
	

}
