package com.joinroot.triplogger.commands;

import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.joinroot.triplogger.commands.Driver;
import com.joinroot.triplogger.commands.Trip;

public class DriverUnitTest {
	
	private final static String DRIVER_NAME = "Test Name";
	private final static LocalTime START_TIME = LocalTime.now();
	private final static LocalTime END_TIME = START_TIME.plusHours(1);
	private final static double TRIP_MILES = 42.0;
	
	private Driver driver;
	
	@Before
	public void setup() {
		driver = new Driver(DRIVER_NAME);
	}
	
	@Test
	public void forty_two_mph_trip_added_when_added_to_history() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, TRIP_MILES);
		driver.addTripToHistory(newTrip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(newTrip, driverTripHistory.get(0));
	}
	
	@Test
	public void five_mph_trip_added_when_added_to_history() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, 5);
		driver.addTripToHistory(newTrip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(newTrip, driverTripHistory.get(0));
	}
	
	@Test
	public void four_mph_trip_discarded_when_added_to_history() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, 4);
		driver.addTripToHistory(newTrip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(0, driverTripHistory.size());
	}
	
	@Test
	public void hundred_mph_trip_added_when_added_to_history() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, 100);
		driver.addTripToHistory(newTrip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(newTrip, driverTripHistory.get(0));
		
	}
	
	@Test
	public void hundred_and_one_mph_trip_discarded_when_added_to_history() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, 101);
		driver.addTripToHistory(newTrip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(0, driverTripHistory.size());
	}
	
	@Test
	public void test_for_get_driver_summary() {
		Trip newTrip = new Trip(DRIVER_NAME, START_TIME, END_TIME, TRIP_MILES);
		driver.addTripToHistory(newTrip);
		
		String actualDriverSummary = driver.getDriverSummary();
		
		Assert.assertEquals("Test Name: 42 miles @ 42 mph", actualDriverSummary);
	}

}
