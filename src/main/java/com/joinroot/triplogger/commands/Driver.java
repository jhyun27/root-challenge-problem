package com.joinroot.triplogger.commands;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.joinroot.triplogger.commands.Trip;

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
		double totalMiles = 0;
		long totalDurationMinutes = 0;
		for (Trip trip : driverTripHistory) {
			totalMiles += trip.getTripMiles();
			totalDurationMinutes += Duration.between(trip.getStartTime(), trip.getEndTime()).toMinutes();
		}
		Long totalMilesLong = Math.round(totalMiles);
		String totalMilesStr = totalMilesLong.toString();

		double totalDurationHours = totalDurationMinutes / 60;
		
		double avgSpeed = totalMiles /  totalDurationHours;
		
		Long avgSpeedLong = Math.round(avgSpeed);
		String avgSpeedStr = avgSpeedLong.toString();
			
		return driverName + ": " + totalMilesStr + " miles @ " + avgSpeedStr + " mph";
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
