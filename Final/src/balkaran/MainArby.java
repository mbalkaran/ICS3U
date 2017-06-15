package balkaran;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * MainArby.java
 * Executes baseball programs - follows path, finds furtherest object each base, and returns home
 * 06/14/2017
 * @author Matthew Balkaran
 */

public class MainArby {

	public static void main(String[] args) {
		Behavior b3 = new ExitProgram(); //highest priority
		Behavior b2 = new Scan();
		Behavior b1 = new Calibrate();
		Behavior b0 = new Movement(); //lowest priority
		Behavior[] behaviors = {b0, b1, b2, b3};
		
		Arbitrator arby = new Arbitrator(behaviors);
		arby.start();
	}

}