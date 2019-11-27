package com.joinroot.triplogger.comparator;

import java.util.Comparator;

import com.joinroot.triplogger.objects.Driver;

public class SortByMilesDesc implements Comparator<Driver>{

	@Override
	public int compare(Driver driver1, Driver driver2) {
		return (int) (driver2.calculateTotalMiles() - driver1.calculateTotalMiles());
	}

}
