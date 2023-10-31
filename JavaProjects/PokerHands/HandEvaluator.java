/**
 * This class represents a HandEvaluator for a card game.
 * It can generate decks, deal hands, and evaluate the probability of different poker hands.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {

	//Create empty ArrayLists for both a deck of cards and a hand
	private ArrayList<Card> Hand = new ArrayList<>();
	private ArrayList<Card> Deck = new ArrayList<>();

	//Fields used to evaluate the card hands
	private int countOfMatches = 0;
	private int handSize = 0;
	private int numberOfHands = 0;
	private boolean pair = false;
	private boolean threeOfAKind = false;
	private boolean fourOfAKind = false;
	private boolean straight = false;
	private boolean flush = false;
	private boolean fullHouse = false;
	private boolean straightFlush = false;
	private boolean royalFlush = false;

	private double probabilityOfPair = 0.0;
	private double probabilityOfThreeOfAKind = 0.0;
	private double probabilityOfFourOfAKind = 0.0;
	private double probabilityOfStraight = 0.0;
	private double probabilityOfFlush = 0.0;
	private double probabilityOfFullHouse = 0.0;
	private double probabilityOfStraightFlush = 0.0;
	private double probabilityOfRoyalFlush = 0.0;

	//Header of CSV 
	private String header = "Pair, Three of a Kind, Four of a Kind, "
			+ "Straight, Flush, Full House, Straight Flush, Royal Flush";

	/**
     * Constructor for the HandEvaluator class.
     * Initializes the deck of cards by calling generateDeck() method.
     */
	public HandEvaluator() {
		generateDeck();
	}

	/**
     * Generates a standard deck of 52 playing cards (No Jokers).
     */
	public void generateDeck() {

		//Creates 13 card objects (2-10, Ace, King, Queen, Jack) with the suit of Spades
		for(int i=14; i > 1; i--) {

			Card card;

			switch(i){
			case 14:
				card = new Card("Spades", "Ace");
				break;
			case 13:
				card = new Card("Spades", "King");
				break;
			case 12:
				card = new Card("Spades", "Queen");
				break;
			case 11:
				card = new Card("Spades", "Jack");
				break;
			default:
				card = new Card("Spades", String.valueOf(i));
				break;
			}

			Deck.add(card);
		}

		//Creates 13 card objects (2-10, Ace, King, Queen, Jack) with the suit of Hearts
		for(int i=14; i > 1; i--) {

			Card card;

			switch(i){
			case 14:
				card = new Card("Hearts", "Ace");
				break;
			case 13:
				card = new Card("Hearts", "King");
				break;
			case 12:
				card = new Card("Hearts", "Queen");
				break;
			case 11:
				card = new Card("Hearts", "Jack");
				break;
			default:
				card = new Card("Hearts", String.valueOf(i));
				break;
			}

			Deck.add(card);
		}

		//Creates 13 card objects (2-10, Ace, King, Queen, Jack) with the suit of Diamonds
		for(int i=14; i > 1; i--) {

			Card card;

			switch(i){
			case 14:
				card = new Card("Diamonds", "Ace");
				break;
			case 13:
				card = new Card("Diamonds", "King");
				break;
			case 12:
				card = new Card("Diamonds", "Queen");
				break;
			case 11:
				card = new Card("Diamonds", "Jack");
				break;
			default:
				card = new Card("Diamonds", String.valueOf(i));
				break;
			}

			Deck.add(card);
		}

		//Creates 13 card objects (2-10, Ace, King, Queen, Jack) with the suit of Clubs
		for(int i=14; i > 1; i--) {

			Card card;

			switch(i){
			case 14:
				card = new Card("Clubs", "Ace");
				break;
			case 13:
				card = new Card("Clubs", "King");
				break;
			case 12:
				card = new Card("Clubs", "Queen");
				break;
			case 11:
				card = new Card("Clubs", "Jack");
				break;
			default:
				card = new Card("Clubs", String.valueOf(i));
				break;
			}

			Deck.add(card);
		}

		Collections.shuffle(Deck);
	}

    /**
     * Deals hands and evaluates them.
     * @param handSize The size of each hand.
     * @param numberOfHands The number of hands to deal and evaluate.
     */
	public void run(int handSize, int numberOfHands) {
		dealHands(handSize, numberOfHands);
	}

	public void evaluateHand() {

		//Sort the hand from lowest to highest by value
		Collections.sort(Hand);

		for (int i = 0; i < Hand.size(); i++) {

			for(int j = i + 1; j < Hand.size(); j++) {
				if (Hand.get(j).getValue().equals(Hand.get(i).getValue())) {
					countOfMatches++;	
				}
			}
		}

		//Checks for pair, three of a kind, and four of a kind
		if (countOfMatches == 1) {
			pair = true;
		} else if (countOfMatches == 3) {
			threeOfAKind = true;
		} else if (countOfMatches == 4) {
			fourOfAKind = true;
		} 
		

		//Checks to see if every card in the hand is one more than the last one
		boolean sequential = checkForSequential();
		if (sequential == true) {
			straight = true;
		}

		//Checks for flush
		boolean allSameSuit = checkForFlush();
		if (allSameSuit == true) {
			flush = true;
		}

		//Checks for full house
		checkForFullHouse();

		//Checks for straight flush
		checkForStraightFlush();

		//Checks for royal flush
		checkForRoyalFlush();

	}

	/**
	 * Checks if the current hand contains a Full House (three cards of one rank and two cards of another).
	 * @return true if the hand contains a Full House, false otherwise.
	 */
	public boolean checkForFullHouse() {
		if (Hand.get(0).getValue().equals(Hand.get(1).getValue()) &&
			Hand.get(1).getValue().equals(Hand.get(2).getValue()) &&
			Hand.get(3).getValue().equals(Hand.get(4).getValue()) ||
			Hand.get(0).getValue().equals(Hand.get(1).getValue()) &&
			Hand.get(2).getValue().equals(Hand.get(3).getValue()) &&
			Hand.get(3).getValue().equals(Hand.get(4).getValue())) {
			fullHouse = true;
		}

		return fullHouse;
	}

	/**
	 * Checks if the current hand contains a Straight Flush (a straight of consecutive ranks with the same suit).
	 * @return true if the hand contains a Straight Flush, false otherwise.
	 */
	public boolean checkForStraightFlush() {
		if(straight == true && flush == true) {
			straightFlush = true;
		}

		return straightFlush;
	}

	/**
	 * Checks if the current hand contains a Royal Flush.
	 * @return true if the hand contains a Royal Flush, false otherwise.
	 */
	public boolean checkForRoyalFlush() {
		if(Hand.get(0).getValue().equals("10") && Hand.get(1).getValue().equals("Jack") && Hand.get(2).getValue().equals("Queen")
				&& Hand.get(3).getValue().equals("King") && Hand.get(4).getValue().equals("Ace") && flush == true) {
			royalFlush = true;
		} else {
			return false;
		}

		return royalFlush;
	}

	/**
	 * Checks if all cards in the current hand have the same suit (Flush).
	 * @return true if all cards have the same suit, false otherwise.
	 */
	public boolean checkForFlush() {
		String suitOfFirstCard = Hand.get(0).getSuit();
		for (Card e : Hand) {
			if (e.getSuit() != suitOfFirstCard) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Checks if the current hand contains a sequence of consecutive ranks (Straight).
	 * @return true if the hand contains a Straight, false otherwise.
	 */
	public boolean checkForSequential() {
		
		for (int i = 0; i < Hand.size()-1; i++) {
			int curr = valueToInt(Hand.get(i).getValue());
			int next = valueToInt(Hand.get(i+1).getValue());

			if (next != curr + 1) {
				return false;
			}
		}

		return true;
	}

	public Card drawCard() {
		Card drawnCard = Deck.get(Deck.size()-1);
		Deck.remove(Deck.size()-1);
		return drawnCard;
	}

	public void drawHand(int handSize) {
		for(int i=0; i < handSize; i++) {
			Hand.add(drawCard());
		}
	} 

	/**
	 * Deals multiple hands.
	 * @param handSize The size of each hand.
	 * @param numberOfHands The number of hands to deal.
	 */
	public void dealHands(int handSize, int numberOfHands) {

		this.numberOfHands = numberOfHands;
		
		int pairCount = 0;
		int threeOfAKindCount = 0;
		int fourOfAKindCount = 0;
		int straightCount = 0;
		int flushCount = 0;
		int fullHouseCount = 0;
		int straightFlushCount = 0;
		int royalFlushCount = 0;

		for (int i = 0; i < numberOfHands; i++) {
			drawHand(handSize);
			evaluateHand();

			if (pair == true) pairCount++;
			if (threeOfAKind == true) threeOfAKindCount++;
			if (fourOfAKind == true) fourOfAKindCount++;
			if (straight == true) straightCount++;
			if (flush == true) flushCount++;
			if (fullHouse == true) fullHouseCount++;
			if (straightFlush == true) straightFlushCount++;
			if (royalFlush == true) royalFlushCount++;

			resetDeck();
		}

		// Calculate probabilities
		probabilityOfPair = ((double) pairCount / numberOfHands) * 100;
		probabilityOfThreeOfAKind = ((double)threeOfAKindCount / numberOfHands) * 100;
		probabilityOfFourOfAKind = ((double)fourOfAKindCount / numberOfHands) * 100;
		probabilityOfStraight = ((double)straightCount / numberOfHands) * 100;
		probabilityOfFlush = ((double)flushCount / numberOfHands) * 100;
		probabilityOfFullHouse = ((double)fullHouseCount / numberOfHands) * 100;
		probabilityOfStraightFlush = ((double)straightFlushCount / numberOfHands) * 100;
		probabilityOfRoyalFlush = ((double)royalFlushCount / numberOfHands) * 100;

		printProbabilites();
		writeToFile(probabilityOfPair, probabilityOfThreeOfAKind, probabilityOfFourOfAKind,
				probabilityOfStraight, probabilityOfFlush, probabilityOfFullHouse, 
				probabilityOfStraightFlush, probabilityOfRoyalFlush);

	}

	public void resetDeck() {
		Deck.addAll(Hand);
		Hand.clear();
		countOfMatches = 0;
		handSize = 0;
		pair = false;
		threeOfAKind = false;
		fourOfAKind = false;
		straight = false;
		flush = false;
		fullHouse = false;
		straightFlush = false;
		royalFlush = false;
		Collections.shuffle(Deck);
	}


	public void printProbabilites() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(5);
		System.out.println("Probability of a pair: " + nf.format(probabilityOfPair) + "%");
		System.out.println("Probability of a three of a kind: " + nf.format(probabilityOfThreeOfAKind) + "%");
		System.out.println("Probability of a four of a kind: " + nf.format(probabilityOfFourOfAKind) + "%");
		System.out.println("Probability of a straight: " + nf.format(probabilityOfStraight) + "%");
		System.out.println("Probability of a flush: " + nf.format(probabilityOfFlush) + "%");
		System.out.println("Probability of a full house: " + nf.format(probabilityOfFullHouse) + "%");
		System.out.println("Probability of a straight flush: " + nf.format(probabilityOfStraightFlush) + "%");
		System.out.println("Probability of a royal flush: " + nf.format(probabilityOfRoyalFlush) + "%");
	}

	/**
     * Writes the probabilities of generated poker hands to a CSV file.
     * @param probabilityOfPair The probability of getting a pair.
     * @param probabilityOfThreeOfAKind The probability of getting three of a kind.
     * @param probabilityOfFourOfAKind The probability of getting four of a kind.
     * @param probabilityOfStraight The probability of getting a straight.
     * @param probabilityOfFlush The probability of getting a flush.
     * @param probabilityOfFullHouse The probability of getting a full house.
     * @param probabilityOfStraightFlush The probability of getting a straight flush.
     * @param probabilityOfRoyalFlush The probability of getting a royal flush.
     */
	public void writeToFile(double probabilityOfPair, double probabilityOfThreeOfAKind, double probabilityOfFourOfAKind,
			double probabilityOfStraight, double probabilityOfFlush, double probabilityOfFullHouse, 
			double probabilityOfStraightFlush, double probabilityOfRoyalFlush) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Hand Probabilites.csv"));
			writer.write(header);
			writer.write("\n");
			writer.write(String.format("%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f%n",probabilityOfPair, probabilityOfThreeOfAKind, probabilityOfFourOfAKind,
					probabilityOfStraight, probabilityOfFlush, probabilityOfFullHouse, 
					probabilityOfStraightFlush, probabilityOfRoyalFlush));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	 /**
     * Converts a card value to an integer.
     * @param value The card value as a string.
     * @return The integer representation of the card value.
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

}
