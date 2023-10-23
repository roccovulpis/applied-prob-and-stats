import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateRandomBirthdays {

	private int numberOfPeople;
	private int numberOfRuns;
	private int[] monthNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private int sharedBirthdayCount;
	private double probabilityOfSharedBirthdays;
	private BigInteger permutationOfBirthdays;
	private Scanner kb = new Scanner(System.in);
	private Random random = new Random();
	private ArrayList<Person> people = new ArrayList<>();

	public GenerateRandomBirthdays() {

		numberOfPeople = getNumberOfPeople();
		numberOfRuns = getNumberOfRuns();
		
		for (int i = 0; i < numberOfRuns; i++) {

			for(int j = 0; j < numberOfPeople; j++) {
				Person p = new Person();
				p.setBirthday(generateRandomBirthday());
				p.setPersonNumber(j);
				people.add(p);
			}
		}

	}



	public void showPeople() {
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
	public void showPercentageOfSharedBirthdays() {
		System.out.println(getCountOfSharedBirthdays(people) + " people share a birthday");
		System.out.println(calculatePercentageOfSharedBirthdays() + "% chance of two people sharing the same birthday");
	}
	
	public int getCountOfSharedBirthdays(ArrayList<Person> people) {
		int countOfSharedBirthdays = 0;
		for (int i = 0; i < numberOfPeople; i++) {
			for (int j = i + 1; j < numberOfPeople; j++) {
				if (people.get(i).getBirthday().equals(people.get(j).getBirthday())) {
					countOfSharedBirthdays++;
					break;
				}
			}
		}
		return countOfSharedBirthdays;
	}

	public int getNumberOfPeople() {
		System.out.println("Enter number of students in the class: ");
		numberOfPeople = kb.nextInt();
		return numberOfPeople;		
	}

	public int getNumberOfRuns() {
		System.out.println("Enter number of runs: ");
		numberOfRuns = kb.nextInt();
		return numberOfRuns;		
	}

	public String generateRandomBirthday() {
		int randomMonth = random.nextInt(monthNumbers.length-1)+1;
		int randomDay = 0;

		switch(randomMonth) {
		case 0:
			randomDay = random.nextInt(31)+1;
			break;
		case 1:
			randomDay = random.nextInt(28)+1;
			break;
		case 2:
			randomDay = random.nextInt(31)+1;
			break;
		case 3:
			randomDay = random.nextInt(30)+1;
			break;
		case 4:
			randomDay = random.nextInt(31)+1;
			break;
		case 5:
			randomDay = random.nextInt(30)+1;
			break;
		case 6:
			randomDay = random.nextInt(31)+1;
			break;
		case 7:
			randomDay = random.nextInt(31)+1;
			break;
		case 8:
			randomDay = random.nextInt(30)+1;
			break;
		case 9:
			randomDay = random.nextInt(31)+1;
			break;
		case 10:
			randomDay = random.nextInt(30)+1;
			break;
		case 11:
			randomDay = random.nextInt(31)+1;
			break;
		}

		return randomMonth + "/" + randomDay;

	}
	
	public double calculatePercentageOfSharedBirthdays() {
		sharedBirthdayCount = getCountOfSharedBirthdays(people);
		probabilityOfSharedBirthdays = sharedBirthdayCount / numberOfRuns;
		return probabilityOfSharedBirthdays;
	}

}
