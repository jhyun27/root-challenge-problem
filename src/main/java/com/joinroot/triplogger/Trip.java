package com.joinroot.triplogger;

import java.time.LocalTime;

public class Trip {
	
	private LocalTime startTime;
	private LocalTime endTime;
	private double tripMiles;
	
	public Trip(LocalTime startTime, LocalTime endTime, double tripMiles) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.tripMiles = tripMiles;
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
