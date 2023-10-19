import java.math.BigInteger;
import java.util.ArrayList;

public class TestStatsLibrary 
{

	public static void main(String[] args) {
		
		StatsLibrary test = new StatsLibrary("Hello World");
		
		ArrayList<Double> testNumbers = new ArrayList<>();
		testNumbers.add(1.0);
		testNumbers.add(4.0);
		testNumbers.add(9.0);
		testNumbers.add(13.0);
		testNumbers.add(19.0);
		testNumbers.add(9.0);
		testNumbers.add(32.0);
		testNumbers.add(32.0);
		
		System.out.println(testNumbers);
		
		double testerResults = test.findMean(testNumbers);
		double testerResults2 = test.findMedian(testNumbers);
		double testerResults3 = test.findMode(testNumbers);
		double testerResults4 = test.findStandardDeviation(testNumbers);
		double testerResults5 = test.findVariance(testNumbers);
		BigInteger testerResults6 = test.findFactorial(4);
		BigInteger testerResults7 = test.findPermutation(9, 8);
		BigInteger testerResults8 = test.findCombination(9, 8);
		double testerResults9 = test.findConditionalProbability(.2, .5);
		
		System.out.println(testNumbers);
		System.out.println("This is the average of test numbers: " + testerResults);
		System.out.println("This is the median of test numbers: " + testerResults2);
		System.out.println("This is the mode of test numbers: " + testerResults3);
		System.out.println("This is the standard deviation of test numbers: " + testerResults4);
		System.out.println("This is the variance of test numbers: " + testerResults5);
		System.out.println("This is the factorial of test numbers: " + testerResults6);
		System.out.println("This is the Permutation of test numbers: " + testerResults7);
		System.out.println("This is the Combination of test numbers: " + testerResults8);
		System.out.println("This is the Conditional Prob of A given B: " + testerResults9);
		
	}
	
}
