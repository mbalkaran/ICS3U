package balkaran;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

/**
 * Scan.java
 * Used in finding object and executing actions at each base
 * 06/14/2017
 * @author Matthew Balkaran
 */
 
public class Scan implements Behavior {
	private SoundSensor sound;
	private LightSensor light;
	private UltrasonicSensor sonar;
	
	public Scan(UltrasonicSensor lm, SoundSensor lt, LightSensor ls){
		this.sonar = lm;
		this.sound = lt;
		this.light = ls;
	}
	
	private boolean suppressed = false;
	int noise = 0;
	int degree = 0;
	int angle = 0;
	int largest = 0;
	int distance = 0;
	
	/**
	 * Robot calls this method to suppress the program
	 * @param no parameters
	 * @return no return
	 */
	
	public void suppress() {
		suppressed = true;
	}
	
	/**
	 * Robot uses method as criteria to take control, this class takes priority based on light sensor (on plate/base)
	 * @param no parameters
	 * @return no return
	 */
	
	public boolean takeControl() {
		if (light.getLightValue() > 47 && light.getLightValue() < 44){ //true if on a base (not on path or table)
			return true; //higher priority, overrides calibrate
		}
		return false;
	}
	
	/**
	 * Robot scans for objects on plate, goes to object, waits for sound, and goes back to plate
	 * @param no parameters
	 * @return no return
	 */
	
	public void action() {
		suppressed = false;
		Delay.msDelay(1000); //gives time for user to end program upon finding home base
		Motor.B.rotate(1440, true); //rotates robot 360 degrees
		while (Motor.B.getTachoCount() < 1440) {
			degree = Motor.B.getTachoCount(); //saves degrees of robot into variable
			distance = sonar.getDistance();
			if (distance > 38) { //negates any distances further than 38cm to find furtherest, 2nd furtherest, and closest object for corresponding bases
				distance = 0;
			}
			if (distance > largest) { //finds largest distance amongst distances found (except those above 35)
			largest = distance;
			angle = degree; //saves degree value of largest distance for base accordingly
			}
		}
		Delay.msDelay(1000); //distinctively separates two rotations
		Motor.B.rotate(angle); //rotates to angle of largest distance
		Delay.msDelay(500); //gives time in-between stopping at angle and moving
		Motor.B.resetTachoCount(); //resets tacho count so it can return to this location
		while (sonar.getDistance() > 7) { //stops 8cm in front of cup
			Motor.B.forward();
			Motor.C.forward();
			degree = Motor.B.getTachoCount(); //saves degrees traveled to cup
		}
		Motor.B.stop();
		Motor.C.stop();
		do {
			noise = sound.readValue(); 
		} while (noise < 49); //stays in infinite loop until hearing a sound before going back to base
		Motor.B.rotate(-degree, true); //rotates robot back to location upon reseting tacho count	
		Motor.C.rotate(-degree); //first rotate is true so both wheels are simultaneous (backwards movement) but wait for robot to finish backing up
		Motor.B.stop();
		Motor.C.stop();
	}
}