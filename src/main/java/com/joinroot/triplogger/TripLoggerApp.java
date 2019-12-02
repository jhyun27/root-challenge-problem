package com.joinroot.triplogger;

import java.io.File;
import java.util.List;

import com.joinroot.triplogger.comparator.SortByMilesDesc;
import com.joinroot.triplogger.filehandler.FileReader;
import com.joinroot.triplogger.filehandler.FileWriter;

public class TripLoggerApp {
	
	public static void main(String[] args) {
		
		if (args.length > 0) {
			String fileName = args[0];
			File file = new File(fileName);
			
			FileReader reader = new FileReader();
			FileWriter writer = new FileWriter();
			List<String> allDriverSummaries = null;
			try {
				allDriverSummaries = reader.read(file);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				throw new RuntimeException(e);
			}
						
			try {
				writer.write(allDriverSummaries);
				System.out.println("Report.txt was successfully generated");
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				throw new RuntimeException(e);
			}
		}
		
	}

}
