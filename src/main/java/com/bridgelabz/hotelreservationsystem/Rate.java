package com.bridgelabz.hotelreservationsystem;

public class Rate {
	
	public Integer weekDay;
	public Integer weekEnd;
	
	public Rate(Integer weekDay,Integer weekEnd) {
		this.weekDay=weekDay;
		this.weekEnd=weekEnd;
	}
	
	public Integer getWeekDayRate() {
		return this.weekDay;
	}
	
	public Integer getWeekEndRate() {
		return this.weekEnd;
	}
}
