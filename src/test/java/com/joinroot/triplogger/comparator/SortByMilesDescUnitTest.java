package com.joinroot.triplogger.comparator;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.joinroot.triplogger.Driver;
import com.joinroot.triplogger.Trip;

public class SortByMilesDescUnitTest {

	private final static LocalTime START_TIME = LocalTime.now();
	private final static LocalTime END_TIME = START_TIME.plusHours(1);

	@Test
	public void sort_by_miles_descending() {
		Driver driver1 = new Driver("Driver One");
		driver1.addTripToHistory(new Trip(START_TIME, END_TIME, 50));
		Driver driver2 = new Driver("Driver Two");
		driver2.addTripToHistory(new Trip(START_TIME, END_TIME, 51));
		Driver driver3 = new Driver("Driver Three");
		driver3.addTripToHistory(new Trip(START_TIME, END_TIME, 52));
		
		List<Driver> drivers = new ArrayList<Driver>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		
		drivers.sort(new SortByMilesDesc());
		
		Assert.assertEquals(driver3, drivers.get(0));
		Assert.assertEquals(driver2, drivers.get(1));
		Assert.assertEquals(driver1, drivers.get(2));
	}

}
