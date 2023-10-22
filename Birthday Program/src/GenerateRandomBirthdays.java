import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateRandomBirthdays {

	private int numberOfPeople;
	private int numberOfRuns;
	private int[] monthNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private int sharedBirthdayCount;
	private BigInteger permutationOfBirthdays;
	private Scanner kb = new Scanner(System.in);
	private Random random = new Random();
	private ArrayList<Person> people = new ArrayList<>();

	public GenerateRandomBirthdays() {

		numberOfPeople = getNumberOfPeople();
		//numberOfRuns = getNumberOfRuns();

		for(int i = 0; i < numberOfPeople; i++) {
			Person p = new Person();
			p.setBirthday(generateRandomBirthday());
			p.setPersonNumber(i);
			people.add(p);
		}

	}

	//	public BigInteger findFactorial(int n) {
	//
	//		BigInteger factorial = new BigInteger(Integer.toString(n));
	//		BigInteger zero = new BigInteger("0");
	//		BigInteger one = new BigInteger("1"); 
	//
	//		if (factorial.equals(zero)) {
	//			factorial = one;
	//		}
	//		else {
	//			for (int i = n; i > 1; i--) {
	//				BigInteger index = new BigInteger(Integer.toString(i)); 
	//				BigInteger oneLessThanIndex = index.subtract(one);
	//				factorial = factorial.multiply(oneLessThanIndex);
	//			}
	//		}
	//
	//		return factorial;
	//
	//	}
	//	
	//	public BigInteger findPermutation(int n, int r) {
	//
	//		BigInteger factorialOfN = findFactorial(n);
	//		int differenceOfNandR = n - r;
	//		BigInteger factorialOfDifference = findFactorial(differenceOfNandR);
	//		BigInteger permutation = factorialOfN.divide(factorialOfDifference);
	//
	//		return permutation;
	//	}

	public void showPeople() {
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
	public void showSharedBirthdays() {
		System.out.println(getCountOfSharedBirthdays(people));
	}
	
	public int getCountOfSharedBirthdays(ArrayList<Person> people) {
		int countOfSharedBirthdays = 0;
		for (int i = 0; i < people.size(); i++) {
			for (int j = i + 1; j < people.size(); j++) {
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

}
