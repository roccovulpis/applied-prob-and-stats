import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game {

	Random random = new Random();

	public void playWithSameDoorChoice() {

		int timesPlayed = 0;
		int correctChoice = 0;
		int incorrectChoice = 0;

		while (timesPlayed < 10000) {

			ArrayList<String> doors = generateDoors();
			int doorChoice = generateDoorChoice(doors);
			revealGoatDoor(doors, doorChoice);

			if (doors.get(doorChoice).equals("New Car")) {
				correctChoice++;
			}
			else {
				incorrectChoice++;
			}

			timesPlayed++;
		}

		double winPercentage = calculateWinPercentage(correctChoice, timesPlayed);

		System.out.println("Selecting the same door every game");
		System.out.println("----------------------------------");
		System.out.println("Correct choice made: " + correctChoice);
		System.out.println("Incorrect choice made: " + incorrectChoice);
		System.out.println("Percentage of wins: " + winPercentage + "%");
		System.out.println();
	}

	public void playDifferentDoorChoice() {

		int timesPlayed = 0;
		int correctChoice = 0;
		int incorrectChoice = 0;

		//Chooses a different door 
		while (timesPlayed < 10000) {

			ArrayList<String> doors = generateDoors();
			
			int doorChoice = generateDoorChoice(doors);
			revealGoatDoor(doors, doorChoice);
			int newDoorChoice = switchDoorChoice(doors, doorChoice);
			
			if (doors.get(newDoorChoice).equals("New Car")) {
				correctChoice++;
			}
			else {
				incorrectChoice ++;
			}

			timesPlayed++;
		}

		double winPercentage = calculateWinPercentage(correctChoice, timesPlayed);

		System.out.println("Selecting a different door every game");
		System.out.println("-------------------------------------");
		System.out.println("Correct choice made: " + correctChoice);
		System.out.println("Incorrect choice made: " + incorrectChoice);
		System.out.println("Percentage of wins: " + winPercentage + "%");
		System.out.println();

	}

	public ArrayList<String> generateDoors(){

		ArrayList<String> doors = new ArrayList<>();
		doors.add("New Car");
		doors.add("Goat");
		doors.add("Goat");

		Collections.shuffle(doors);

		return doors;
	}

	public int generateDoorChoice(ArrayList<String> doors) {

		int doorChoice = random.nextInt(doors.size());

		return doorChoice;
	}

	public void revealGoatDoor(ArrayList<String> doors, int choice) {

		int losingIndex = 0;

		for(int i = 0; i < doors.size(); i++) {
			if(!doors.get(i).equals("New Car") && i != choice) {
				losingIndex = i;
			}
		}

		doors.set(losingIndex, "Visible Goat");

	}
	
	public int switchDoorChoice(ArrayList<String> doors, int choice) {

		int newDoorChoice = 0;

		for(int i = 0; i < doors.size(); i++) {
			if(!doors.get(i).equals("Visible Goat") && i != choice) {
				newDoorChoice = i;
			}
		}

		return newDoorChoice;
	}

	public double calculateWinPercentage(double correctChoice, double timesPlayed) {

		double percentageOfWins = correctChoice / timesPlayed;
		percentageOfWins = percentageOfWins * 100;
		return percentageOfWins;
	} 

}
