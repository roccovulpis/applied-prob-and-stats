/**
 * Represents a playing card with a suit and a value. 
 * Provides methods to get the suit and value of the card, 
 * convert the card's value to an integer, and compare two cards based on their values.
 * 
 * @author Rocco Vulpis
 * @version 10/30/23
 */
public class Card implements Comparable<Card> {

	//Fields 
	private String suit = null;
	private String value = null;

	/**
	 * Constructs a new card with the given suit and value.
	 * 
	 * @param suit  the suit of the card
	 * @param value the value of the card
	 */
	public Card(String suit, String value) {
		this.suit = suit;
		this.value = value;
	}

	/**
	 * Returns the suit of the card.
	 * 
	 * @return suit the suit of the card
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * Returns the value of the card.
	 * 
	 * @return value the value of the card
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Returns a string representation of the card, in the format "value of suit".
	 * 
	 * @return a string representation of the card
	 */
	public String toString() {
		return value + " of " + suit;
	}

	/**
	 * Converts the value of the card to an integer. Number cards are converted to their numeric value, 
	 * while face cards are converted as follows: Jack = 11, Queen = 12, King = 13, and Ace = 14.
	 * 
	 * @param value the value of the card
	 * @return the integer value of the card
	 */
	public int valueToInt(String value) {
		switch (value) {
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6":
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "10":
			return 10;
		case "Jack":
			return 11;
		case "Queen":
			return 12;
		case "King":
			return 13;
		case "Ace":
			return 14;
		default:
			return 0;
		}
	}

	/**
	 * Compares this card with another card for order based on their values. 
	 * Returns a negative integer, zero, or a positive integer as this card is less than, equal to, or greater than the specified card.
	 * 
	 * @param o the other card to compare with
	 * @return a negative integer, zero, or a positive integer as this card is less than, equal to, or greater than the specified card
	 */
	@Override
	public int compareTo(Card o) {
		int firstValue = valueToInt(this.value);
		int nextValue = valueToInt(o.value);
		return firstValue - nextValue;
	}
}
