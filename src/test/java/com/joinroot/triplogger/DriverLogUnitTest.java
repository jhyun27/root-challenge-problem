package com.joinroot.triplogger;

import java.time.LocalTime;
import java.util.List;

import org.junit.*;

import com.joinroot.triplogger.objects.Driver;
import com.joinroot.triplogger.objects.Trip;

public class DriverLogUnitTest {
	
	private final static String DRIVER_NAME = "Test Name";
	private final static LocalTime START_TIME = LocalTime.now();
	private final static LocalTime END_TIME = START_TIME.plusHours(1);
	private final static double TRIP_MILES = 42.0;
	
	private DriverLog log;
	
	@Before
	public void setup() {
		log = new DriverLog();
	}
	
	@Test
	public void register_new_driver_does_not_register_existing_driver() {
		Driver driver = new Driver(DRIVER_NAME);
		log.registerNewDriver(driver);
		Driver driver2 = new Driver(DRIVER_NAME);
		log.registerNewDriver(driver2);
		
		List<Driver> allDrivers = log.getAllDrivers();
		
		Assert.assertEquals(1, allDrivers.size());
	}
	
	@Test
	public void add_trip_to_driver_history_adds_trip_to_correct_driver() {
		Driver driver = new Driver(DRIVER_NAME);
		log.registerNewDriver(driver);
		Trip trip = new Trip(START_TIME, END_TIME, TRIP_MILES);
		log.addTripToDriverHistory(DRIVER_NAME, trip);
		
		List<Trip> driverTripHistory = driver.getDriverTripHistory();
		
		Assert.assertEquals(1, driverTripHistory.size());
	}
	
	@Test
	public void add_trip_to_driver_history_does_not_add_trip_to_unregistered_driver() {
		
	}

}
