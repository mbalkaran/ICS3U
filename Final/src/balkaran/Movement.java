package balkaran;

import lejos.nxt.Motor;
import lejos.robotics.subsumption.Behavior;

/**
 * Movement.java
 * Basic forward movement, used in path following
 * 06/14/2017
 * @author Matthew Balkaran
 */
 
public class Movement implements Behavior {
	private boolean suppressed = false;
	
	/**
	 * Robot calls this method to suppress the program
	 * @param no parameters
	 * @return no return
	 */
	
	public void suppress() {
		suppressed = true;
	}
	
	/**
	 * Robot uses method as criteria to take control, this class is the lowest priority so it is always true
	 * @param no parameters
	 * @return no return
	 */
	
	public boolean takeControl() {
		return true; //lowest priority, always true if no other higher priority is true
	}
	
	/**
	 * Robot moves forward whilst class has control
	 * @param no parameters
	 * @return no return
	 */
	
	public void action() {
		suppressed = false;
		Motor.B.forward();
		Motor.C.forward();
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}