package com.joinroot.triplogger.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.joinroot.triplogger.commands.Trip;
import com.joinroot.triplogger.commands.Driver;

public class FileReader {

	private final static String DRIVER = "Driver";
	private final static String TRIP = "Trip";
	
	public List<Driver> read(File file) {
		List<Driver> allDrivers = new ArrayList<Driver>();
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String[] lineFromFile = fileScanner.nextLine().split(" ");
				String command = lineFromFile[0];
				
				if (command.equalsIgnoreCase(DRIVER) ) {
					String driverName = lineFromFile[1];
					Driver newDriver = new Driver(driverName);
					allDrivers.add(newDriver);
				} else if (command.equalsIgnoreCase(TRIP)) {
					String driverName = lineFromFile[1];
					double tripMiles = Double.parseDouble(lineFromFile[4]);
					LocalTime startTime = LocalTime.parse(lineFromFile[2], DateTimeFormatter.ofPattern("HH:mm"));
					LocalTime endTime = LocalTime.parse(lineFromFile[3], DateTimeFormatter.ofPattern("HH:mm"));
					
					Trip newTrip = new Trip(driverName, startTime, endTime, tripMiles);
					// add trip to driver's history
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found");
			e.printStackTrace();
		}
		return allDrivers;
	}

}