package com.bridgelabz.hotelreservationsystemtest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;

import com.bridgelabz.hotelreservationsystem.CustomerType;
import com.bridgelabz.hotelreservationsystem.HotelReservationSystem;
import com.bridgelabz.hotelreservationsystem.Rate;


public class HotelReservationSystemTest {
	
	HotelReservationSystem hotelReservationSystem;
	
	@Test
	public void addingHotel_IfDone_ShouldReturnSize() {
		
		
		Integer arraySizeL = hotelReservationSystem.hotelName.size()+1;
		HashMap<CustomerType, Rate> map = new HashMap<CustomerType,Rate>();
		map.put(CustomerType.Regular, new Rate(110,90));
		map.put(CustomerType.Rewarded, new Rate(80,80));
		hotelReservationSystem = new HotelReservationSystem("Lakewood",3,map);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultL = hotelReservationSystem.hotelDetails();
		Assert.assertEquals(arraySizeL, resultL);

		
		Integer arraySizeB = hotelReservationSystem.hotelName.size()+1;		
		HashMap<CustomerType, Rate> mapB = new HashMap<CustomerType,Rate>();
		mapB.put(CustomerType.Regular, new Rate(160,40));
		mapB.put(CustomerType.Rewarded, new Rate(110,50));
		hotelReservationSystem = new HotelReservationSystem("Bridgewood",4,mapB);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultB = hotelReservationSystem.hotelDetails();
		Assert.assertEquals(arraySizeB, resultB);
		
		Integer arraySizeR = hotelReservationSystem.hotelName.size()+1;
		HashMap<CustomerType, Rate> mapR = new HashMap<CustomerType,Rate>();
		mapR.put(CustomerType.Regular, new Rate(220,150));
		mapR.put(CustomerType.Rewarded, new Rate(100,40));
		hotelReservationSystem = new HotelReservationSystem("Ridgewood",5,mapR);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultR = hotelReservationSystem.hotelDetails();
		Assert.assertEquals(arraySizeR, resultR);
		
		
	}
	
	@Test
	public void findHotelName_AllCheapestHotel_ShouldReturnNameWithTotalRate() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.calculateHotel(inputDate);
		Assert.assertEquals("Lakewood and Bridgewood, Total Rates: 200", name);
		
	}
	
	
	@Test
	public void findHotelName_CheapestAmongAll_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.calculateHotel(inputDate);
		Assert.assertEquals("Lakewood, Total Rates: 220", name);
		
	}
}
