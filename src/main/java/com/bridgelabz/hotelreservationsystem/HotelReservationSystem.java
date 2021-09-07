package com.bridgelabz.hotelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
	
	public String bestRatedHotel(String inputDate) {

		String[] names = resultHotel(inputDate);
		String[] hotel = names[0].split(" and ");
		
		Map<String,Integer> ratingName = new HashMap<>();
		Integer ratings= 0;
		for(String n: hotel){
			for(int i=0;i<hotelName.size();i++) {
				if (hotelName.get(i).name.equals(n)) {
					ratingName.put(n, hotelName.get(i).rating);
					ratings = Math.max(ratings, hotelName.get(i).rating);
				}
			}
		}
		final Integer ratingsD = ratings;
		ArrayList<String> ratedHotel = Arrays.asList(hotel).stream().filter(n -> ratingName.get(n).equals(ratingsD)).collect(Collectors.toCollection(ArrayList::new));
		
		return String.join(" and ", ratedHotel) + ", Rating: " + ratings + " and Total Rates: "+names[1];
	}
	
	
	
	public String[] resultHotel(String inputDate){
		String[] inputArr = inputDate.split(",");
		DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		ArrayList<LocalDate> dateArr = new ArrayList<>();
		dateArr.add(LocalDate.parse(inputArr[0],fomat));
		long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));
		
		//Done this so that after passing into stream can get rate for many days as well.
		while(noOfDaysBetween>0) {
			dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
			noOfDaysBetween--;
		}
		
		Integer[] rate=new Integer[] {0,0,0};
		ArrayList<String> nameHotel = new ArrayList<String>();
		
		dateArr.stream().forEach(n->{
			for(int i=0;i<hotelName.size();i++) {
				if (n.getDayOfWeek().getValue() == 6 || n.getDayOfWeek().getValue() == 7) {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;
				}
				else {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;
				}
			}
		});
		
		
		//Added this for adding multiple hotel name
		Integer value = Collections.min(Arrays.asList(rate));
		
		for(int i=0;i<rate.length;i++) {
			if (rate[i].equals(value)) {
				nameHotel.add(hotelName.get(i).name);
			}
		}
		String[] names = new String[2];
		names[0]= String.join(" and ", nameHotel);
		names[1]= String.valueOf(value);
		return names;
	}
	
	
	
	public String calculateHotel(String inputDate){
		
		String[] names = resultHotel(inputDate);
		return names[0] + ", Total Rates: "+ Integer.valueOf(names[1]);
	}
	
	
	public String bestRatedHotelName(String inputDate) {
		String[] inputArr = inputDate.split(",");
		DateTimeFormatter fomat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		ArrayList<LocalDate> dateArr = new ArrayList<>();
		dateArr.add(LocalDate.parse(inputArr[0],fomat));
		long noOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.parse(inputArr[0],fomat), LocalDate.parse(inputArr[1],fomat));
		
		//Done this so that after passing into stream can get rate for many days as well.
		while(noOfDaysBetween>0) {
			dateArr.add(dateArr.get(dateArr.size()-1).plusDays(1));
			noOfDaysBetween--;
		}
		
		Integer[] rate=new Integer[] {0,0,0};
		ArrayList<String> nameHotel = new ArrayList<String>();
		
		dateArr.stream().forEach(n->{
			for(int i=0;i<hotelName.size();i++) {
				if (n.getDayOfWeek().getValue() == 6 || n.getDayOfWeek().getValue() == 7) {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekEnd;
				}
				else {
					rate[i] += hotelName.get(i).rates.get(CustomerType.Regular).weekDay;
				}
			}
			
		});
		
		Integer ratings= 0;
		for(int i=0;i<hotelName.size();i++) {
			ratings = Math.max(ratings, hotelName.get(i).rating);
		}
		
		final Integer ratingsD = ratings;
		ArrayList<HotelReservationSystem> highRatedHotel = hotelName.stream().filter(n-> n.rating.equals(ratingsD)).collect(Collectors.toCollection(ArrayList::new));
		
		ArrayList<String> hotelNameVariable= new ArrayList<>();
		
		Integer value =0;
		for(int i=0;i<highRatedHotel.size();i++) {
			for(int j=0;j<hotelName.size();j++) {
				if ((hotelName.get(j).name).equals(highRatedHotel.get(i).name)) {
					hotelNameVariable.add(highRatedHotel.get(i).name);
					value = rate[j];
				}
			}
		}
		
		return String.join(" and ", hotelNameVariable) + ", Total Rates: " +value;
	}
	
	
	//Added just to view entered values
	public void toPrint() {
		for(int i=0;i<3;i++) {
			System.out.println(hotelName.get(i).rates.get(CustomerType.Regular).weekDay);
			System.out.println(hotelName.get(i).rates.get(CustomerType.Regular).weekEnd);
		}
	}
	
}
