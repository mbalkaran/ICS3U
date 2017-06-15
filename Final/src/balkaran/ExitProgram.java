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

	/**
	 * Robot uses method as criteria to take control, this class takes highest override priority based on gray button push 
	 * @param no parameters
	 * @return no return
	 */
	
	public boolean takeControl() {
		if(Button.ESCAPE.isDown()) {
			return true; //highest priority, if clicked, ends program since overrides all
		}
		return false;
	}

	/**
	 * Robot exits program
	 * @param no parameters
	 * @return no return
	 */
	
	public void action() {
		System.exit(0);
	}
	
	/**
	 * Robot calls this method to suppress the program, no suppress is necessary since it ends the program
	 * @param no parameters
	 * @return no return
	 */
	
	public void suppress() {
		
	}
}