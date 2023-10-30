/**
 * The Factory class generates a list of Car objects with random attributes and provides functionality to 
 * write the list to a CSV file as well as read data back into another list from a CSV file.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Factory {

	//Fields
	private Random random = new Random();
	private String header = "CarType, Year, Color, Miles";
	private String[] carTypes = new String[] {"Sedan", "SUV", 
			"Hatchback", "Minivan", "Electric", "Hybrid", "Convertible", "Sedan"};
	private String[] carColors = new String[] {"Red", "Black",
			"White", "Grey", "Blue", "Orange", "Yellow", "Red"};
	private ArrayList<Car> cars = new ArrayList<>();
	private ArrayList<Car> carsFromFile = new ArrayList<>();

	 /**
     * Constructor that generates 1000 Car objects with random attributes and adds them to the cars list.
     */
	public Factory() {

		for(int i = 0; i < 1000; i++) {
			Car car = new Car();
			car.setCarType(randomlySelectArrayElement(carTypes));
			car.setYear(random.nextInt(50) + 1973);
			car.setColor(randomlySelectArrayElement(carColors));
			car.setMiles(random.nextInt(250000));

			cars.add(car);
		}

	}

	 /**
     * Prints each Car object from the carsFromFile list to the console.
     */
	public void getFileCars(){
		for(Car car : carsFromFile) {
			System.out.println(car);
		}
	}

	
	/**
     * Randomly selects and returns an index number passed in from one of the two String arrays 
     * 
     * @param elements The array to select from.
     * @return slectedElement A randomly selected element from the array.
     */
	public String randomlySelectArrayElement(String[] elements) {
		int index = random.nextInt(elements.length);
		String selectedElement = elements[index];
		return selectedElement;
	}

	  /**
     * Writes the Car objects from the cars list to a CSV file.
     */
	public void writeToFile() {

		try {
			//Write to a file named "cars.csv" in the default workspace directory
			BufferedWriter writer = new BufferedWriter(new FileWriter("cars.csv"));
			//Write the header to the CSV file outside of the loop
			writer.write(header);

			for(int i = 0; i < cars.size(); i++) {
				writer.write("\n");
				writer.write(cars.get(i).toString());
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * Reads Car objects from a CSV file and adds them to the carsFromFile list.
     */
	public void readFile() {

		try {
			//Read from a file named "cars.csv" in the default workspace directory
			BufferedReader reader = new BufferedReader(new FileReader("cars.csv"));
			String csvLine;
			//Skip the header of the CSV file
			reader.readLine();
			while((csvLine = reader.readLine()) != null) {
				String[] csvCarAttributes = csvLine.split(", ");
				if(csvCarAttributes.length == 4) {
					Car car = new Car();
					car.setCarType(csvCarAttributes[0]);
					car.setYear(Integer.parseInt(csvCarAttributes[1]));
					car.setColor(csvCarAttributes[2]);
					car.setMiles(Integer.parseInt(csvCarAttributes[3]));
					carsFromFile.add(car);
				}
			} 
			reader.close();
			getFileCars();
			System.out.println("\n Cars successfully loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
