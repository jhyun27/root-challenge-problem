package com.joinroot.triplogger;

import java.util.ArrayList;
import java.util.List;

import com.joinroot.triplogger.exception.UnregisteredDriverException;

public class DriverLog {
	
private List<Driver> allDrivers;
	
	public DriverLog() {
		allDrivers = new ArrayList<Driver>();
	}
	
	public void registerNewDriver(Driver newDriver) {
		if (getDriverByName(newDriver.getDriverName()) == null) {
			allDrivers.add(newDriver);
		}
	}
	
	public void addTripToDriverHistory(String driverName, Trip trip) {
		Driver driver = getDriverByName(driverName);
		if (driver != null) {
			driver.addTripToHistory(trip);
		} else {
			throw new UnregisteredDriverException("Error: Cannot add a trip for an unregistered driver.");
		}
	}
	
	private Driver getDriverByName(String name) {
		for(Driver driver : allDrivers) {
			if (driver.getDriverName().equalsIgnoreCase(name)) {
				return driver;
			}
		}
		return null;
	}

	public List<Driver> getAllDrivers() {
		return allDrivers;
	}

	public void setAllDrivers(List<Driver> allDrivers) {
		this.allDrivers = allDrivers;
	}

}
