package com.pratik.corona.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.pratik.corona.Model.CoronaData;

@Service
public class CoronaVirusServices {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

	public static List<CoronaData> fetchvisusData() throws IOException {
		List<CoronaData> list = new ArrayList<>();

		URL u = new URL(VIRUS_DATA_URL);

		HttpURLConnection ht = (HttpURLConnection) u.openConnection();

		InputStream im = ht.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(im));
	//	String line = br.readLine();

		CSVReader reader = new CSVReader(br);
		List<String[]> allRows = reader.readAll().stream().skip(1).collect(Collectors.toList());

		// Iterable<CSVRecord> allRows = CSVFormat.DEFAULT.parse(br);
		// List<CSVRecord> rs=records.
		for (String[] record : allRows) {

			CoronaData cd = new CoronaData();
//	        	    String state = record.get(0);
//	        	    String country=record.get(1);
			// int
			// latestTotalCases=Integer.parseInt(record.get((record.get(record.size()-1))));
			// int latestTotalCases=record.get((record.size()-1));
			cd.setState(record[0]);
			cd.setCountry(record[1]);
			try {
				cd.setLatestTotalCases(Integer.parseInt(record[record.length - 1]));
			} catch (Exception e) {

			}

			// System.out.println(cd);
			list.add(cd);
			cd = null;

		}
		System.out.println(list);
		return list;

	}
}
