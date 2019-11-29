# Root Challenge Problem

## Running the Program
To run this program:

	1. cd root-challenge-problem/src/main/java
	2. javac com/joinroot/triplogger/TripLoggerApp.java
	3. java com/joinroot/triplogger/TripLoggerApp path-to-input-file

Execution successful if the following message is received:

	Report.txt was successfully generated.
	

## Design Approach

My initial design included a Trip, Driver, FileReader, FileWriter, and main class from which the application would run. In order to visualize how these classes would interact, I started by creating skeletons of each class. I then used TDD in order to pass the parameters given in the problem statement. Once my application was successfully writing the log out to a file, I added a comparator to sort the final report by miles (descending). I also ended up adding a DriverLog class and tests in order to further encapsulate my Driver from my FileReader.

### Testing
Unit testing was determined by the parameters outlined in the problem statement such as:

	1. Discard any trips that average a speed of less than 5 mph or greater than 100 mph.
	2. Generate a report containing each driver with total miles driven and average speed. 
	3. Report should round miles and miles per hour to the nearest integer
	4. Report should be sorted by most miles driven to least.

I also created a file called rootSampleInput.txt with the sample input from the problem statement. This was used to test File I/O. The following parameters were considered and tested using this method:

	1. FileWriter is generating the expected file
	2. Output sorted by most miles driven to least.

Upon further evaluation, I also added unit testing for the SortByMilesDesc comparator class.

### FileReader Class
FileReader has one public read method that reads each line of the file in a try block and throws a FileNotFound exception to display an error message from the main method in the TripLoggerApp, and translates the input into the proper object (Driver or Trip).

### FileWriter Class


### Driver Class
The "Driver" command in the input file creates a new Driver object. Each driver must have a unique name. I debated whether or not to add a unique Driver ID, but decided not to as the example given in the problem statement seemed to use first names as unique identifiers. Each driver also has an ArrayList of Trip(s) that act as his/her trip history.

### Trip Class
The "Trip" command in the input file creates a new Trip object. Each Trip must have a start time (LocalTime), end time (LocalTime), and trip miles. These values are parsed in the FileReader in order to make a new Trip. This trip is then added to a specific driver's history through the DriverLog.

### Encapsulation
I eventually decided to further encapsulate the Driver class from my FileReader class by incorporating a DriverLog which would hold the list of all registered drivers.

### Exception Handling
