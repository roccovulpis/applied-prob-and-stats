/**
 * The TestMontyHallSimulator class contains the main method for running the Monty Hall simulator.
 * It creates an instance of the MontyHallSimulator class and initiates the simulation by calling 
 * its two different play methods.
 * 
 * @author Rocco Vulpis
 * @version 10/30/2023
 */
public class TestMontyHallSimulator {

	public static void main(String[] args) {
		
	MontyHallSimulator game = new MontyHallSimulator();
	game.playWithSameDoorChoice();
	game.playDifferentDoorChoice();
		
	}
}
