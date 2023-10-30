/**
 * The MontyHallSimulator class simulates the Monty Hall problem, where a user is given three doors
 * to choose from. Two doors hold goats, and one holds a new car. The user selects a door, and a goat door
 * is then revealed. The user then has the option to either switch doors or keep the same one.
 * This class provides methods that simulate the probability of winning in the scenario that the user
 * keeps the same door or switches doors in 10,000 runs.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MontyHallSimulator {

	Random random = new Random();
	
	/**
     * Simulates the Monty Hall problem with the same door choice.
     * It runs 10,000 games to calculate the win percentage when keeping the same door choice.
     */
	public void playWithSameDoorChoice() {

		int timesPlayed = 0;
		int correctChoice = 0;
		int incorrectChoice = 0;

		//Simulate 10,000 times
		while (timesPlayed < 10000) {

			//Create an ArrayList that contains two goats and one car
			ArrayList<String> doors = generateDoors();
			//Randomly select a door
			int doorChoice = generateDoorChoice(doors);
			//Reveal a door that contains a goat that is not the initial choice
			revealGoatDoor(doors, doorChoice);

			//If the door choice contains a car, increment the count of correct choices
			if (doors.get(doorChoice).equals("New Car")) {
				correctChoice++;
			}
			//If the door choice does not contain a car, increment the count of incorrect choices
			else {
				incorrectChoice++;
			}
			//Increment the amount of times the game is played by one
			timesPlayed++;
		}

		//Store the percentage of wins
		double winPercentage = calculateWinPercentage(correctChoice, timesPlayed);

		//Print the results to the console
		System.out.println("Selecting the same door every game");
		System.out.println("----------------------------------");
		showWinPercentage(timesPlayed, correctChoice, incorrectChoice, winPercentage);
		
	}

	/**
     * Simulates the Monty Hall problem with a different door choice.
     * It runs 10,000 games to calculate the win percentage when changing the door choice.
     */
	public void playDifferentDoorChoice() {

		int timesPlayed = 0;
		int correctChoice = 0;
		int incorrectChoice = 0;

		//Simulate 10,000 times
		while (timesPlayed < 10000) {

			//Create an ArrayList that contains two goats and one car
			ArrayList<String> doors = generateDoors();
			//Randomly select a door
			int doorChoice = generateDoorChoice(doors);
			//Reveal a door that contains a goat that is not the initial choice
			revealGoatDoor(doors, doorChoice);
			//Switch the door choice to the other "closed" door
			int newDoorChoice = switchDoorChoice(doors, doorChoice);
			
			//If the door choice contains a car, increment the count of correct choices
			if (doors.get(newDoorChoice).equals("New Car")) {
				correctChoice++;
			}
			//If the door choice does not contain a car, increment the count of incorrect choices
			else {
				incorrectChoice ++;
			}
			
			//Increment the amount of times the game is played by one
			timesPlayed++;
		}
		
		//Store the percentage of wins
		double winPercentage = calculateWinPercentage(correctChoice, timesPlayed);

		//Print the results to the console
		System.out.println("Selecting a different door every game");
		System.out.println("-------------------------------------");
		showWinPercentage(timesPlayed, correctChoice, incorrectChoice, winPercentage);
		
	}

	 /**
     * Generates a list of doors with one car and two goats, shuffles them randomly, and returns the result.
     *
     * @return doors ArrayList containing shuffled doors.
     */
	public ArrayList<String> generateDoors(){

		//Create an ArrayList of doors
		ArrayList<String> doors = new ArrayList<>();
		doors.add("New Car");
		doors.add("Goat");
		doors.add("Goat");

		//Randomize the door indices 
		Collections.shuffle(doors);

		return doors;
	}

	/**
     * Generates a random door choice index from the list of doors.
     *
     * @param doors ArrayList of doors.
     * @return doorChoice Index of the chosen door.
     */
	public int generateDoorChoice(ArrayList<String> doors) {

		//Store a random index number from the door list
		int doorChoice = random.nextInt(doors.size());

		return doorChoice;
	}

	/**
     * Reveals one of the goat doors that the player didn't choose.
     *
     * @param doors ArrayList of doors.
     * @param choice Index of the player's door choice.
     */
	public void revealGoatDoor(ArrayList<String> doors, int choice) {

		//Initialize the losing index
		int losingIndex = 0;

		//Loop through the doors
		for(int i = 0; i < doors.size(); i++) {
			//Conditional to store the index of the losing door that was not selected 
			if(!doors.get(i).equals("New Car") && i != choice) {
				losingIndex = i;
			}
		}

		//Set the element of losing index to "Visible Goat"
		doors.set(losingIndex, "Visible Goat");

	}
	
	/**
     * Switches the door choice to a different door after revealing a goat door.
     *
     * @param doors ArrayList of doors.
     * @param choice Index of the player's initial door choice.
     * @return newDoorChoice Index of the newly chosen door.
     */
	public int switchDoorChoice(ArrayList<String> doors, int choice) {

		//Initialize the new door choice
		int newDoorChoice = 0;

		//Loop through the doors
		for(int i = 0; i < doors.size(); i++) {
			//If the current door doesn't have a visible goat and isn't the player's original choice, switch to this door.
			if(!doors.get(i).equals("Visible Goat") && i != choice) {
				newDoorChoice = i;
			}
		}

		//Return the new door choice
		return newDoorChoice;
	}

	/**
     * Calculates and returns the win percentage based on the number of correct choices and total games played.
     *
     * @param correctChoice Number of correct choices.
     * @param timesPlayed Total games played.
     * @return percentageOfWinsn Win percentage as a double.
     */
	public double calculateWinPercentage(double correctChoice, double timesPlayed) {

		//Calculate the win percentage (desired outcomes / total outcomes)
		double percentageOfWins = correctChoice / timesPlayed;
		//Multiply by 100 to return a percentage 
		percentageOfWins = percentageOfWins * 100;
		return percentageOfWins;
	} 
	
	/**
     * Prints the results of the simulation.
     *
     * @param timesPlayed Total games played.
     * @param correctChoice Number of correct choices.
     * @param incorrectChoice Incorrect number of choices
     * @param winPercentage Calculation of the percentage of wins
     */
	public void showWinPercentage(int timesPlayed, int correctChoice, int incorrectChoice, 
			double winPercentage) {
		
		System.out.println("Correct choice made: " + correctChoice);
		System.out.println("Incorrect choice made: " + incorrectChoice);
		System.out.println("Percentage of wins: " + winPercentage + "%");
		System.out.println();
	}

}
