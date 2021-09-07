package com.bridgelabz.hotelreservationsystem;

import java.util.ArrayList;

public class HotelReservationSystem {
	
	public static ArrayList<HotelReservationSystem> hotelName = new ArrayList<>();
	String name;
	Integer rating;
	Integer weekDayRegular;
	Integer weekDayRewarded;
	Integer weekEndRegular;
	Integer weekEndRewarded;
	
	public HotelReservationSystem(String name,Integer rating,Integer weekDayRegular,Integer weekDayRewarded,Integer weekEndRegular,Integer weekEndRewarded) {
		this.name = name;
		this.rating = rating;
		this.weekDayRegular = weekDayRegular;
		this.weekDayRewarded= weekDayRewarded;
		this.weekEndRegular = weekEndRegular;
		this.weekEndRewarded = weekEndRewarded;
	}
	
	public void addHotel(HotelReservationSystem hotelReservationSystem) {
		hotelName.add(hotelReservationSystem);
	}
	
	public Integer hotelDetails() {
		return hotelName.size(); 
	}
	
	
}
