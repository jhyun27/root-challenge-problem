package com.joinroot.triplogger;

import java.io.File;
import java.util.List;

import com.joinroot.triplogger.commands.Driver;
import com.joinroot.triplogger.filehandler.FileReader;
import com.joinroot.triplogger.filehandler.FileWriter;

public class TripLogger {

	private static FileReader reader;
	private static FileWriter writer;
	private final static String FILENAME =  "rootSampleInput.txt";
	
	public static void main(String[] args) {
		reader = new FileReader();
		writer = new FileWriter();
		
		File file = new File(FILENAME);
		
		List<Driver> allDrivers = reader.read(file);
		writer.write(allDrivers);
		
//		if (args.length > 0) {
//			System.out.println(args[0]);
//			String fileName = args[0];
//			file = new File(fileName);
//		}
		
	}

}
