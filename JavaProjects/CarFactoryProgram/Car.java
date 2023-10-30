/**
 * The Car class represents a car with a type, year, color, and miles.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
public class Car {
	
	//Fields 
	private String carType;
	private int year;
	private String color;
	private int miles;
	
	/**
	 * Gets the type of the car.
	 * @return The type of the car.
	 */
	public String getCarType() {
		return carType;
	}
	
	/**
	 * Sets the type of the car.
	 * @param carType The type of the car.
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * Gets the year of the car.
	 * @return The year of the car.
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the year of the car.
	 * @param year The year of the car.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the color of the car.
	 * @return The color of the car.
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Sets the color of the car.
	 * @param color The color of the car.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the miles on the car.
	 * @return The miles on the car.
	 */
	public int getMiles() {
		return miles;
	}
	
	/**
	 * Sets the miles on the car.
	 * @param miles The miles on the car.
	 */
	public void setMiles(int miles) {
		this.miles = miles;
	}
	
	/**
	 * Returns a string representation of the car.
	 * @return A string representation of the car, which includes the type, year, color, and miles.
	 */
	public String toString() {
		return carType + ", " + year + ", " + color + ", " + miles;
	}
		
}