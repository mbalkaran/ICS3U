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
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {
		return true; //lowest priority, always true if no other higher priority is true
	}
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