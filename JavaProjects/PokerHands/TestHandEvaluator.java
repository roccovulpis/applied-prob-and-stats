/**
 * The TestHandEvaluator class contains the main method for running the poker hand simulator.
 * It creates an instance of the HandEvaluator class and initiates the simulation by calling its run method.
 * 
 * @author Rocco Vulpis
 * @version 10/30/23
 */
public class TestHandEvaluator {
	
	public static void main(String[] args) {
		
		HandEvaluator eval = new HandEvaluator();
		eval.run(5, 1000000);
	}

}
