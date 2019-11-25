package com.joinroot.triplogger.commands;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	
	private String driverName;
	private List<Trip> driverTripHistory;
	
	public Driver(String driverName) {
		this.driverName = driverName;
		driverTripHistory = new ArrayList<Trip>();
	}
	

	public void addTripToHistory(Trip newTrip) {
		driverTripHistory.add(newTrip);
	}
	
	public String getDriverSummary() {
		return null;
	}
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public List<Trip> getDriverTripHistory() {
		return driverTripHistory;
	}

	public void setDriverTripHistory(List<Trip> driverTripHistory) {
		this.driverTripHistory = driverTripHistory;
	}

}
