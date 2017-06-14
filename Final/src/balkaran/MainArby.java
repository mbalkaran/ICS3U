package balkaran;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * @author 324118041
 *
 */

public class MainArby {

	public static void main(String[] args) {
		Behavior b3 = new ExitProgram();
		Behavior b2 = new Scan();
		// Behavior b1 = new Calibrate();
		// Behavior b0 = new Movement();
		Behavior[] behaviors = {b2, b3};
		
		Arbitrator arby = new Arbitrator(behaviors);
		arby.start();
	}

}
 