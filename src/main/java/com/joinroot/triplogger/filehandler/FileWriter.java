package com.joinroot.triplogger.filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.joinroot.triplogger.Driver;
import com.joinroot.triplogger.DriverLog;

public class FileWriter {
	
	private final static String FILE_NAME = "Report.txt";
	
	public void write(List<String> allDriverSummaries) throws IOException {
		
		File outputFile = new File(FILE_NAME);
		
		try ( PrintWriter writer = new PrintWriter(outputFile);
				BufferedWriter buffered = new BufferedWriter(writer) ) {

			for (String summary : allDriverSummaries) {
				buffered.write(summary);
				buffered.newLine();
			}
			
		}
	}

}
