package com.joinroot.triplogger.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.joinroot.triplogger.commands.Driver;

public class FileReader {

	private List<Driver> allDrivers;
	
	public FileReader() {
		allDrivers = new ArrayList<Driver>();
	}
	
	public List<Driver> read(File file) {
		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				String[] lineFromFile = fileScanner.nextLine().split(" ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File Not Found or contains errors");
			e.printStackTrace();
		}
		return allDrivers;
	}

}
