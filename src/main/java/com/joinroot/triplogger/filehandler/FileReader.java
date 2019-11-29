package com.joinroot.triplogger.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.joinroot.triplogger.DriverLog;
import com.joinroot.triplogger.objects.Driver;
import com.joinroot.triplogger.objects.Trip;

public class FileReader {

	private final static String DRIVER = "Driver";
	private final static String TRIP = "Trip";
	
	private DriverLog log;
	
	public FileReader() {
		log = new DriverLog();
	}
	
	public List<Driver> read(File file) throws FileNotFoundException {
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String[] lineFromFile = fileScanner.nextLine().split(" ");
				createNewDriverOrTrip(lineFromFile);
			}
		}
		return log.getAllDrivers();
	}
	
	private void createNewDriverOrTrip(String[] lineFromFile) {
		String command = lineFromFile[0];
		String driverName = lineFromFile[1];
		if (command.equalsIgnoreCase(DRIVER) ) {
			Driver newDriver = new Driver(driverName);
			log.registerNewDriver(newDriver);
		} else if (command.equalsIgnoreCase(TRIP)) {
			Trip newTrip = createTripFromFile(lineFromFile);
			log.addTripToDriverHistory(driverName, newTrip);
		}
	}
	
	private Trip createTripFromFile(String[] lineFromFile) {
		double tripMiles = Double.parseDouble(lineFromFile[4]);
		LocalTime startTime = LocalTime.parse(lineFromFile[2], DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime endTime = LocalTime.parse(lineFromFile[3], DateTimeFormatter.ofPattern("HH:mm"));
		Trip newTrip = new Trip(startTime, endTime, tripMiles);
		return newTrip;
	}

}