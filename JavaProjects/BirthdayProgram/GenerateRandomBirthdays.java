/**
 * The GenerateRandomBirthdays class simulates and calculates the probability of shared birthdays
 * among a group of people for a specified number of runs.
 * This class provides methods to set simulation parameters, run the simulation, and display the results.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateRandomBirthdays {

	//Fields 
	private int numberOfPeople = 0;
	private int numberOfRuns = 0;
	private int[] monthNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private double probabilityOfSharedBirthdays = 0.0;
	private Scanner kb = new Scanner(System.in);
	private Random random = new Random();

	 /**
     * Default constructor for GenerateRandomBirthdays.
     */
	public GenerateRandomBirthdays() {

	}

	 /**
     * Constructor for GenerateRandomBirthdays with parameters.
     * @param numberOfPeople The number of people in each simulation run.
     * @param numberOfRuns The number of simulation runs to perform.
     * @param monthNumbers An array of month numbers (1-12) for generating random birthdays.
     * @param probabilityOfSharedBirthdays The initial probability of shared birthdays.
     */
	public GenerateRandomBirthdays(int numberOfPeople, int numberOfRuns, 
			int[] monthNumbers, double probabilityOfSharedBirthdays) {
		this.numberOfPeople = numberOfPeople;
		this.numberOfRuns = numberOfRuns;
		this.monthNumbers = monthNumbers;
		this.probabilityOfSharedBirthdays = probabilityOfSharedBirthdays;
	}

	/**
     * This method is called in the main method to run the entire birthday simulation.
     * It uses user input, performs the simulation, and displays the results.
     */
	public void run() {

		//Store the number of people and runs by calling the setNumberOfPeople and setNumberOfRuns method
		numberOfPeople = setNumberOfPeople();
		numberOfRuns = setNumberOfRuns();

		//Initialize the counter for shared birthdays
		int sharedBirthdayCount = 0;

		//Iterate through the number of runs specified by the user
		for (int i = 0; i < numberOfRuns; i++) {

			//Initialize ArrayList to store Person objects for each run
			ArrayList<Person> people = new ArrayList<>();

			//Create Person objects with randomly generated birthdays
			for(int j = 0; j < numberOfPeople; j++) {
				Person p = new Person();
				p.setBirthday(generateRandomBirthday());
				people.add(p);
			}

			//Store the count of shared birthdays for this run
			sharedBirthdayCount = sharedBirthdayCount + getCountOfSharedBirthdays(people);
		}

		//Calculate the probability of shared birthdays and display the percentage
		probabilityOfSharedBirthdays = ((double)sharedBirthdayCount / numberOfRuns) * 100;
		showPercentageOfSharedBirthdays(sharedBirthdayCount, probabilityOfSharedBirthdays);

	}

	/**
	 * Print the probability of two people sharing the same birthday to the console
	 * @param sharedBirthdayCount The count of shared birthdays.
     * @param probability The calculated probability.
	 */
	public void showPercentageOfSharedBirthdays(int sharedBirthdayCount, double probability) {
		System.out.println(probability + "% chance of two people sharing the same birthday");
	}

	/**
	 * Return the count of shared birthdays within the ArrayList of people
	 * @param people ArrayList of Person objects
	 * @return The count of shared birthdays
	 */
	public int getCountOfSharedBirthdays(ArrayList<Person> people) {

		//Initialize a counter to store shared birthdays
		int currentSharedBirthdayCount = 0;
		//Loop through the people ArrayList starting from the first element
		for (int i = 0; i < people.size(); i++) {
			//Inner loop starting at the second element of the people ArrayList
			for (int j = i + 1; j < people.size(); j++) {
				/*
				 * Compare the i and the i + 1 elements to check for a shared birthday
				 * If there is a match, increment count and exit the inner loop
				 */
				if (people.get(i).getBirthday().equals(people.get(j).getBirthday())) {
					currentSharedBirthdayCount++;
					break;
				}
			}

			//If a shared birthday is found, exit the outer loop
			if (currentSharedBirthdayCount > 0) {
				break;
			}
		}

		//Return the count of shared birthdays
		return currentSharedBirthdayCount;
	}

	/**
	 * Prompt user to enter desired number of people and returns the value entered
	 * @return numbebrOfPeople The number of people
	 */
	public int setNumberOfPeople() {
		System.out.println("Enter number of students in the class: ");
		numberOfPeople = kb.nextInt();
		return numberOfPeople;		
	}

	/**
	 * Prompt user to enter desired number of runs and returns the value entered
	 * @param
	 * @return numberOfRuns The number of runs 
	 */
	public int setNumberOfRuns() {
		System.out.println("Enter number of runs: ");
		numberOfRuns = kb.nextInt();
		return numberOfRuns;		
	}

	/**
	 * Generate random birthdays in MM/DD format
	 * @return randomBirthday Month and day in MM/DD
	 */
	public String generateRandomBirthday() {

		//Generate a random month from 1-12 
		int randomMonth = random.nextInt(monthNumbers.length)+1;
		//Initializes a variable to hold a value for the day of the month
		int randomDay = 0;

		/*
		 * Conditional statement to generate a random day (1-31) based off which month was generated
		 * February (month 2) can only generate values from 1-28 (leap years not considered)
		 */
		switch(randomMonth) {
		case 1:
			randomDay = random.nextInt(31)+1;
			break;
		case 2:
			randomDay = random.nextInt(28)+1;
			break;
		case 3:
			randomDay = random.nextInt(31)+1;
			break;
		case 4:
			randomDay = random.nextInt(30)+1;
			break;
		case 5:
			randomDay = random.nextInt(31)+1;
			break;
		case 6:
			randomDay = random.nextInt(30)+1;
			break;
		case 7:
			randomDay = random.nextInt(31)+1;
			break;
		case 8:
			randomDay = random.nextInt(31)+1;
			break;
		case 9:
			randomDay = random.nextInt(30)+1;
			break;
		case 10:
			randomDay = random.nextInt(31)+1;
			break;
		case 11:
			randomDay = random.nextInt(30)+1;
			break;
		case 12:
			randomDay = random.nextInt(31)+1;
			break;
		}

		//Return a date in MM/DD format
		String randomBirthday = randomMonth + "/" + randomDay;
		return randomBirthday;

	}

}