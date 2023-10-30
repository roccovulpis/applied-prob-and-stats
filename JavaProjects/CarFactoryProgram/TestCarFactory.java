/**
 * The TestCarFactory class contains the main method for running the car factory.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
public class TestCarFactory {

	public static void main(String[] args) {
		Factory factory = new Factory();
		factory.writeToFile();
		factory.readFile();
	}

}
