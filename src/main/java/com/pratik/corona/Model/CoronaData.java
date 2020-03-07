package com.pratik.corona.Model;

public class CoronaData {
	
	private String state;
	private String country;
	private String latestTotalCases;
	
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
	public String getLatestTotalCases() {
		return latestTotalCases;
	}
	public void setLatestTotalCases(String string) {
		this.latestTotalCases = string;
	}
	
	@Override
	public String toString() {
		return "CoronaData [state=" + state + ", country=" + country + ", latestTotalCases=" + latestTotalCases + "]";
	}
	
	
	
	

}
