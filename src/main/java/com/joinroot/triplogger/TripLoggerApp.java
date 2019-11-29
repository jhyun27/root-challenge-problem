package com.joinroot.triplogger;

import java.io.File;
import java.util.List;

import com.joinroot.triplogger.comparator.SortByMilesDesc;
import com.joinroot.triplogger.filehandler.FileReader;
import com.joinroot.triplogger.filehandler.FileWriter;

public class TripLoggerApp {
	
	public static void main(String[] args) {
		
//		if (args.length > 0) {
//			String fileName = args[0];
			File file = new File("rootSampleInput.txt");
			
			FileReader reader = new FileReader();
			FileWriter writer = new FileWriter();
			List<Driver> allDrivers;
			try {
				allDrivers = reader.read(file);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				throw new RuntimeException(e);
			}
			
			allDrivers.sort(new SortByMilesDesc());
			
			try {
				writer.write(allDrivers);
				System.out.println("Report.txt was successfully generated");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				throw new RuntimeException(e);
			}
//		}
		
	}

}
