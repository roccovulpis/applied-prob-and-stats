
public class Person {
	
	private int personNumber;
	private String birthday;

	public Person() {
		
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public int getPersonNumber() {
		return personNumber;
	}
	
	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}
	
	public String toString() {
		return "Person number " + personNumber + " was born on: " + birthday;
	}

}
