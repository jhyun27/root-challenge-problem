package com.joinroot.triplogger.filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.joinroot.triplogger.objects.Driver;

public class FileWriter {
	
	private final static String FILE_NAME = "Report.txt";
	
	public void write(List<Driver> allDrivers) throws IOException {
		
		File outputFile = new File(FILE_NAME);
		
		try ( PrintWriter writer = new PrintWriter(outputFile);
				BufferedWriter buffered = new BufferedWriter(writer) ) {

			for (Driver driver : allDrivers) {
				buffered.write(driver.getDriverSummary());
				buffered.newLine();
			}
			
		}
	}

}
