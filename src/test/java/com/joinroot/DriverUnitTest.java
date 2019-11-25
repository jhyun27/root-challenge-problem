package com.joinroot;

import org.junit.Before;
import org.junit.Test;

import com.joinroot.triplogger.commands.Driver;

public class DriverUnitTest {
	
	private final static String DRIVER_NAME = "Test Name";
	
	private Driver driver;
	
	@Before
	public void setup() {
		driver = new Driver(DRIVER_NAME);
	}
	
	@Test
	public void test_for_add_trip_to_history() {
		
	}
	
	@Test
	public void test_for_get_driver_summary() {
		
	}

}
