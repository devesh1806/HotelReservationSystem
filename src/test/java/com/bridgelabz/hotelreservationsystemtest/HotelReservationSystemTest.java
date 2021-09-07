package com.bridgelabz.hotelreservationsystemtest;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

import com.bridgelabz.hotelreservationsystem.HotelReservationSystem;


public class HotelReservationSystemTest {
	
	HotelReservationSystem hotelReservationSystem;
	
	@Test
	public void addingHotel_IfDone_ShouldReturnTrue() {
		
		
		Integer arraySizeL = hotelReservationSystem.hotelName.size()+1;
		hotelReservationSystem = new HotelReservationSystem("Lakewood",3,110,80,90,80);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultL = hotelReservationSystem.hotelDetails();
		System.out.println(resultL);
		Assert.assertEquals(arraySizeL, resultL);

		
		Integer arraySizeB = hotelReservationSystem.hotelName.size()+1;		
		hotelReservationSystem = new HotelReservationSystem("Bridgewood",4,160,110,60,50);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultB = hotelReservationSystem.hotelDetails();
		System.out.println(resultB);
		Assert.assertEquals(arraySizeB, resultB);
		
		Integer arraySizeR = hotelReservationSystem.hotelName.size()+1;
		hotelReservationSystem = new HotelReservationSystem("Ridgewood",5,220,100,150,40);
		hotelReservationSystem.addHotel(hotelReservationSystem);
		Integer resultR = hotelReservationSystem.hotelDetails();
		Assert.assertEquals(arraySizeR, resultR);
		
	}
	
}
