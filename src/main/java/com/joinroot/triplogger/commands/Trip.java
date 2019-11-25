package com.joinroot.triplogger.commands;

import java.time.LocalTime;

public class Trip {
	
	private String driverName;
	private LocalTime startTime;
	private LocalTime endTime;
	private double tripMiles;
	
	public Trip(String driverName, LocalTime startTime, LocalTime endTime, double tripMiles) {
		this.driverName = driverName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.tripMiles = tripMiles;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public double getTripMiles() {
		return tripMiles;
	}
	public void setTripMiles(double tripMiles) {
		this.tripMiles = tripMiles;
	}

}
