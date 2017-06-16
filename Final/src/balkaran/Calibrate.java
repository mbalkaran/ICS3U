package balkaran;

import lejos.nxt.LCD;
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
	private boolean exit = false;
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
		if (light.getLightValue() > 31 && light.getLightValue() < 48) { //true if off of black tape path
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
		exit = false;
		if (exit == false) {
			Motor.B.rotate(360, true);
			while (Motor.B.isMoving() && !suppressed) {
				LCD.drawInt(1, 0, 0); //for debugging
				if (light.getLightValue() < 31) { //stops if it finds path
					Motor.B.stop();
					exit = true; //each exit  = true prevents further calibrating
				}
			}
		}
		if (exit == false) {
			Motor.B.rotate(-360); //doesn't need to prevent further calibrating since this only undoes previous action
		}
		if (exit == false) {
			Motor.C.rotate(360, true);
			while (Motor.C.isMoving() && !suppressed) {
				LCD.drawInt(2, 0, 1); //for debugging
				if (light.getLightValue() < 31) { //same as above
					Motor.C.stop();
					exit = true;//same as above
				}
			}
		}
		if (exit == false) {
			Motor.C.rotate(-360);
		}
		//rotates 90 degrees left and back, and right and back (180 degrees in front of robot)
		if (exit == false) {
			Motor.B.rotate(120, true);
			while (Motor.B.isMoving() && !suppressed) {
				LCD.drawInt(3, 0, 2); //for debugging
				if (light.getLightValue() < 31) { //same as above
					Motor.B.stop();
					exit = true; //same as above

				}
			}
		}
		if (exit == false) {
			Motor.B.rotate(120, true);
			Motor.C.rotate(120);
			while (Motor.C.isMoving() && Motor.B.isMoving() && !suppressed) {
				LCD.drawInt(4, 0, 3); //for debugging
				if (light.getLightValue() < 31) { //same as above
					Motor.C.stop();
					Motor.B.stop();
					exit = true; //same as above
				}
			}
		}
		//shifts forward, to the left, helps in trying to find home base at the end of program
		Motor.B.stop();
		Motor.C.stop();
	}
}
