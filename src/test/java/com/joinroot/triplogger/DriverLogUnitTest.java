package com.joinroot.triplogger;

import java.util.List;

import org.junit.*;

import com.joinroot.triplogger.objects.Driver;

public class DriverLogUnitTest {
	
	private DriverLog log;
	
	@Before
	public void setup() {
		log = new DriverLog();
	}
	
	@Test
	public void register_new_driver_does_not_register_existing_driver() {
		Driver driver = new Driver("Test Name");
		log.registerNewDriver(driver);
		Driver driver2 = new Driver("Test Name");
		log.registerNewDriver(driver2);
		
		List<Driver> allDrivers = log.getAllDrivers();
		
		Assert.assertEquals(1, allDrivers.size());
	}

}
