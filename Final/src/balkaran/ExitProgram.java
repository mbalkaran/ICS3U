package balkaran;

import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

/**
 * ExitProgram.java
 * Exits program upon escape button press, highest priority over all
 * 06/14/2017
 * @author Matthew Balkaran
 */
 
public class ExitProgram implements Behavior {

	public boolean takeControl() {
		if(Button.ESCAPE.isDown()) {
			return true; //highest priority, if clicked, ends program since overrides all
		}
		return false;
	}
	public void action() {
		System.exit(0);
	}
	public void suppress() {
		
	}
}