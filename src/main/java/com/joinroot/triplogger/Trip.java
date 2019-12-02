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

	public LocalTime getEndTime() {
		return endTime;
	}
	
	public double getTripMiles() {
		return tripMiles;
	}

}
