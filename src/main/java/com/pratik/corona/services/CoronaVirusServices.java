package com.pratik.corona.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.pratik.corona.Model.CoronaData;



@Service
public class CoronaVirusServices {

	private static String VIRUS_DATA_URL ="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/who_covid_19_situation_reports/who_covid_19_sit_rep_time_series/who_covid_19_sit_rep_time_series.csv";
	

	    
	public static List<CoronaData> fetchvisusData() throws IOException
	{
		  List<CoronaData> list=new ArrayList<>();
		 
		 
		 URL u=new URL("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv");
	        HttpURLConnection ht=(HttpURLConnection)u.openConnection();
	        int status=(ht.getResponseCode());
	     
	        	InputStream im=ht.getInputStream();
	        	BufferedReader br=new BufferedReader(new InputStreamReader(im));
	        	String line=br.readLine();
	       
	          	Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(br);
	        	for (CSVRecord record : records) {
	        		
	        		CoronaData cd=new CoronaData();
	        	    String state = record.get(0);
	        	    String country=record.get(1);
	        	    //String latestTotalCases=record.get(Integer.parseInt(record.get(record.size()-1)));
	        	    String latestTotalCases=record.get((record.size()-1));
	        	    cd.setState(state);
	        	    cd.setCountry(country);
	        	    cd.setLatestTotalCases(latestTotalCases);
	        	   // System.out.println(cd);
	        	    list.add(cd);
	        	    
	        
	        	}
				return list;
	        	
	}
	}
	


