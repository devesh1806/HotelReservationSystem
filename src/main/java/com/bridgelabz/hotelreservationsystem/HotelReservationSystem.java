package com.bridgelabz.hotelreservationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.math3.analysis.solvers.RegulaFalsiSolver;

public class HotelReservationSystem {
	
	public static ArrayList<HotelReservationSystem> hotelName = new ArrayList<>();
	
	String name;
	Integer rating;
	Map<CustomerType,Rate> rates;
	
	public HotelReservationSystem() {
	
	}
	
	public HotelReservationSystem(String name,Integer rating,Map<CustomerType,Rate> rates) {
		this.name = name;
		this.rating = rating;
		this.rates = rates;
	}
	
	public void addHotel(HotelReservationSystem hotelReservationSystem) {
		hotelName.add(hotelReservationSystem);
	}
	
	public Integer hotelDetails() {
		return hotelName.size(); 
	}
	
	public String calculateHotel(String inputDate){
		
		String[] inputArr = inputDate.split(",");
		DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		ArrayList<LocalDate> dateArr = new ArrayList<>();
		dateArr.add(LocalDate.parse(inputArr[0],fomat));
		long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));
		
		while(noOfDaysBetween>0) {
			dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
			noOfDaysBetween--;
		}
		
		Integer[] rate=new Integer[] {0,0,0};
		dateArr.stream().forEach(n->{
			for(int i=0;i<hotelName.size();i++) {
				if (n.getDayOfWeek().getValue()==6 || n.getDayOfWeek().getValue()==7) {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;
				}
				else {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;
				}
			}
		});
		
		Integer n = Arrays.asList(rate).indexOf(Collections.min(Arrays.asList(rate)));
		System.out.println(hotelName.get(n).name + ", Rate: " + rate[n]);
		
		return hotelName.get(n).name;
	}
	
	
}
