package balkaran;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

/**
 * Calibrate.java
 * Used to re-calibrate onto path and find home
 * 06/14/2017
 * @author Matthew Balkaran
 */

public class Calibrate implements Behavior {
	private boolean suppressed = false;
	private LightSensor light;
	public Calibrate(LightSensor ls){
		this.light = ls;
	}	
	
	/**
	 * Robot calls this method to suppress the program
	 * @param no parameters
	 * @return no return
	 */
	
	public void suppress() {
		suppressed = true;
	}
	
	/**
	 * Robot uses method as criteria to take control, this class takes priority based on light sensor (off black path)
	 * @param no parameters
	 * @return no return
	 */
	
	public boolean takeControl() {
		if (light.getLightValue() > 34) { //true if off of black tape path
			return true;
		}
		return false;
	}
	
	/**
	 * Robot calibrates back onto path or plate whilst it has control, once calibrated it suppresses itself
	 * @param no parameters
	 * @return no return
	 */
	
	public void action() {
		suppressed = false;
		Motor.C.rotate(360, true);
		while (Motor.C.isMoving()) {
			if (light.getLightValue() < 35) { //stops if it finds path
				Motor.C.stop();
				suppressed = true; //each suppressed = true prevents further calibrating
			}
		}
		Motor.C.rotate(-360); //doesn't need to prevent further calibrating since this only undoes previous action
		Motor.B.rotate(360, true);
		while (Motor.B.isMoving()) {
			if (light.getLightValue() < 35) { //same as above
				Motor.C.stop();
				suppressed = true;
			}
		}
		Motor.B.rotate(-360);
		//rotates 90 degrees left and back, and right and back (180 degrees in front of robot)
		Motor.C.rotate(120, true);
		while (Motor.C.isMoving()) {
			if (light.getLightValue() < 35) { //same as above
				Motor.C.stop();
				suppressed = true;
			}
		}
		Motor.C.rotate(120, true);
		Motor.B.rotate(120);
		while (Motor.C.isMoving() && Motor.B.isMoving()) {
			if (light.getLightValue() < 35) { //same as above
				Motor.C.stop();
				suppressed = true;
			}
		}
		//shifts forward, to the left, helps in trying to find home base at the end of program
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}
