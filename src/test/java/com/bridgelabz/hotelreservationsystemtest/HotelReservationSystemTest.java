package com.bridgelabz.hotelreservationsystemtest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.FixMethodOrder;

import com.bridgelabz.hotelreservationsystem.CustomerType;
import com.bridgelabz.hotelreservationsystem.HotelReservationSystem;
import com.bridgelabz.hotelreservationsystem.MoodAnalysisException;
import com.bridgelabz.hotelreservationsystem.Rate;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HotelReservationSystemTest {
	
	HotelReservationSystem hotelReservationSystem;
	
	@Test
	public void addingHotelName_HavingRatingNameIfDone_ShouldReturnSize() {
		
		
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
	public void findHotelName_RegularAllCheapestHotel_ShouldReturnNameWithTotalRate() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.calculateHotel(inputDate,"Regular");
		Assert.assertEquals("Lakewood and Bridgewood, Total Rates: 200", name);
		
	}
	
	
	@Test
	public void findHotelName_RegularCheapestAmongAll_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.calculateHotel(inputDate,"Regular");
		Assert.assertEquals("Lakewood, Total Rates: 220", name);
		
	}
	
	@Test
	public void findHotelName_RegularCheapestRatingAmongAll_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.bestRatedHotel(inputDate,"Regular");
		Assert.assertEquals("Bridgewood, Rating: 4 and Total Rates: 200", name);
		
	}
	
	@Test
	public void findHotelName_RegularBestRatingAmongAll_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		String name = hotelReservationSystem.bestRatedHotelName(inputDate,"Regular");
		Assert.assertEquals("Ridgewood, Rating: 5 and Total Rates: 370", name);
		
	}
	
	@Test
	public void findHotelName_BestRatingAmongAllRewarded_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();

		String name = hotelReservationSystem.bestRatedHotelName(inputDate,"Rewarded");
		Assert.assertEquals("Ridgewood, Rating: 5 and Total Rates: 140", name);
	}
	
	@Test
	public void findHotelName_BestRatingAmongAllRewardedHavingException_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		try {
			boolean result = hotelReservationSystem.validateInput(inputDate);
			Assert.assertEquals(true, result);
			String name = hotelReservationSystem.bestRatedHotelName(inputDate,"Rewarded");
			Assert.assertEquals("Ridgewood, Rating: 5 and Total Rates: 140", name);
		}
		catch(MoodAnalysisException exception) {
			exception.getMessage();
		}
		
	}
	
	@Test
	public void findHotelName_RegularBestRatingAmongAllHavingException_ShouldReturnName() {
		
		Scanner sc = new Scanner(System.in);
		String inputDate = sc.nextLine();
		hotelReservationSystem = new HotelReservationSystem();
		try {
			boolean result = hotelReservationSystem.validateInput(inputDate);
			Assert.assertEquals(true, result);
			String name = hotelReservationSystem.bestRatedHotel(inputDate,"Regular");
			Assert.assertEquals("Bridgewood, Rating: 4 and Total Rates: 200", name);
		}
		catch(MoodAnalysisException exception) {
			exception.getMessage();
		}
	}
}
