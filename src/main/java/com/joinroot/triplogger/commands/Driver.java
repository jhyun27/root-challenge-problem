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
		String totalMilesStr = calculateTotalMiles().toString();
		String avgSpeedStr = calculateAvgSpeed().toString();
		return driverName + ": " + totalMilesStr + " miles @ " + avgSpeedStr + " mph";
	}
	
	private Long calculateTotalMiles() {
		double totalMiles = 0;
		for (Trip trip : driverTripHistory) {
			totalMiles += trip.getTripMiles();
		}
		Long totalMilesLong = Math.round(totalMiles);
		return totalMilesLong;
	}
	
	private Long calculateAvgSpeed() {
		double totalDurationMinutes = 0;
		for (Trip trip : driverTripHistory) {
			totalDurationMinutes += Duration.between(trip.getStartTime(), trip.getEndTime()).toMinutes();
		}
		double totalDurationHours = totalDurationMinutes / 60;
		double avgSpeedDouble = calculateTotalMiles() /  totalDurationHours;
		Long avgSpeedLong = Math.round(avgSpeedDouble);
		return avgSpeedLong;
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
