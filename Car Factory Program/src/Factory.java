import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Factory {

	private Random random = new Random();

	private String header = "CarType, Year, Color, Miles";

	private String[] carTypes = new String[] {"Sedan", "SUV", 
			"Hatchback", "Minivan", "Electric", "Hybrid", "Convertible", "Sedan"};

	private String[] carColors = new String[] {"Red", "Black",
			"White", "Grey", "Blue", "Orange", "Yellow", "Red"};

	private ArrayList<Car> cars = new ArrayList<>();

	private ArrayList<Car> carsFromFile = new ArrayList<>();

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

	//Neatly prints the list of car objects line by line
	public void getFileCars(){
		for(Car car : carsFromFile) {
			System.out.println(car);
		}
	}

	//Randomly selects and returns an index number passed in from one of the two String arrays 
	public String randomlySelectArrayElement(String[] elements) {
		int index = random.nextInt(elements.length);
		String selectedElement = elements[index];
		return selectedElement;
	}

	//Writes out each car object to a .csv file where the file is generated in the Car Factory project directory
	public void writeToFile() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("cars.csv"));
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

	//Reads in and loads each line from a .csv file in the Car Factory directory 
	public void readFile() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("cars.csv"));
			String csvLine;
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
