/**
 * The class Person represents a person with a birthday 
 * It contains methods to get and set the birthday of the person
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
public class Person {
	
	//Fields
	private String birthday;

	/**
	 * Default Constructor for Person
	 */
	public Person() {
		
	}
	
	/**
	 * Get the birthday of the person
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	
	/**
	 * Set the birthday of the person
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
