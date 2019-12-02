# Root Challenge Problem

## Running the Program
To run this program:

	1. cd root-challenge-problem/src/main/java
	2. javac com/joinroot/triplogger/TripLoggerApp.java
	3. java com/joinroot/triplogger/TripLoggerApp path-to-input-file

Execution successful if the following message is received:

	Report.txt was successfully generated.
	

## Design Approach

My initial design included a `Trip`, `Driver`, `FileReader`, `FileWriter`, and `TripLoggerApp` class from which the application would run. In order to visualize how these classes would interact, I started by creating skeletons of each class. I then used TDD in order to meet the requirements outlined in the problem statement. Once my application was successfully writing out to a file, I added a comparator to sort the final report by miles (descending). I also ended up adding a `DriverLog` class and tests in order to encapsulate my `Driver` class.

## Testing
Unit tests were determined by the requirements outlined in the problem statement such as:

	1. Discard any trips that average a speed of less than 5 mph or greater than 100 mph.
	2. Generate a report containing each driver with total miles driven and average speed. 
	3. Report should round miles and miles per hour to the nearest integer.
	4. Report should be sorted by most miles driven to least.

I also created a file called `rootSampleInput.txt` with the sample input from the problem statement. This was used to test File I/O. The following parameters were considered and tested using this method:

	1. FileWriter is generating the expected file.
	2. Output sorted by most miles driven to least.
	3. "Driver" command in input file registers a new Driver.
	4. "Trip" command in input file records a trip attributed to a driver.

## FileReader Class
`FileReader` has a `read()` method that translates each line of a file and executes the proper command ("Driver" or "Trip"). `FileNotFoundException` is thrown to the `TripLoggerApp` class where it will display an error message to the user.

The `FileReader` originally communicated directly with the `Driver` class and held its own `List` of all drivers, but I decided to separate this function and encapsulate the `Driver` class by adding a `DriverLog` class. The `FileReader` now communicates with the `DriverLog` in order to register new drivers and add trips to a driver's history. It also obtains a `List` of all driver summaries, which is then passed to the `FileWriter` in `TripLoggerApp`.

## FileWriter Class
`FileWriter` has a `write()` method that generates a file named `Report.txt`. It records driver summaries for each registered driver, showing the total miles of all of their trips and their average speed. `IOException` is thrown to the `TripLoggerApp` class where it will display an error message to the user.

I originally communicated directly between the `FileWriter` and `Driver` classes, but to encapsulate the `Driver` class, I created a method in `DriverLog` to pass a `List` of driver summaries to the `FileReader`, who would then pass this list to the `FileWriter` when they meet in `TripLoggerApp`.

I also decided to use the `PrintWriter` in conjunction with the `BufferedWriter` to ensure accuracy and avoid any data loss in the case of large transfers of data.

## DriverLog Class
The `DriverLog` holds the list of all registered drivers. This is where drivers would be "registered." This class communicates with the `FileReader` and `Driver` classes to add trips to a driver's history and generate a list of all driver summaries.

I ensure that new drivers(s) have a unique identifier (name) before registering. I do this by looping through the `List` of all registered drivers and cross-referencing them with the new driver's name.

I also ensure that trips are only added to existing drivers. Similarly, I loop through the `List` of all registered drivers and cross reference this to the name given with the "Trip" command in the input file.

This class is also responsible for generating and sorting the `List` of driver summaries that will eventually be printed out via the `FileWriter`.

## Driver Class
The "Driver" command in the input file creates a new `Driver` object. Each `Driver` must have a unique name. I debated whether or not to add a unique Driver ID, but decided not to as the example given in the problem statement seemed to use first names as unique identifiers. Each `Driver` also has an `ArrayList` of `Trip`(s) that act as his/her trip history.

The `Driver` class also has multiple methods to calculate total miles and average speeds for their trip history. `calculateAvgSpeed()` and `calculateTotalMiles()` are used to generate driver summaries. `calculateTotalMiles()` is also used in the comparator `SortByMilesDes()`. And `calculateTripSpeed()` is used to determine whether the trip is between 5-100 mph before logging.

Calculations are done using the primitive type `double`, and then rounded into the `Long` wrapper class when needed using `Math.round()`. The `Long` wrapper class was chosen for use of the `.toString()` method when generating the driver summary.

## Trip Class
The "Trip" command in the input file creates a new `Trip` object. Each `Trip` must have a start time (`LocalTime`), end time (`LocalTime`), and trip miles (`double`). These values are parsed in the `FileReader` in order to make a new `Trip`. This `Trip` is then added to a specific driver's history through the `addTripToDriverHistory()` method in `DriverLog`.

## Exception Handling
I originally included an `UnregisteredDriverException` that would be thrown when a trip was added for an unregistered driver. I ultimately decided to remove this exception, because I did not think that the entire application should abort when these errors occurred. Instead, the application will continue but not log the trip.

Exceptions that are consciously thrown are the `FileNotFoundException` in the `FileReader` and `IOException` in the `FileWriter`.

## Additional Improvements
Additional improvements that could be made include a reporting log that will record any errors that occur during execution. These errors could include adding `Trip`(s) to an unregistered `Driver`, registering a `Driver` that already exists, or entering an invalid `Trip` (e.g. null times, negative trip miles).
