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
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	SoundSensor sound = new SoundSensor(SensorPort.S3, true);
	private LightSensor light = new LightSensor(SensorPort.S2);
	private boolean suppressed = false;
	int degree = 0;
	int angle = 0;
	int largest = 0;
	int distance = 0;
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {
		if (light.getLightValue() > 47){ //true if off of black tape path and off table (on a base)
			return true; //higher priority, overrides calibrate
		}
		return false;
	}
	public void action() {
		suppressed = false;
		Delay.msDelay(1000); //gives time for user to end program upon finding home base
		Motor.B.rotate(1440, true); //rotates robot 360 degrees
		while (Motor.B.getTachoCount() < 1440) {
			degree = Motor.B.getTachoCount(); //saves degrees of robot into variable
			distance = sonar.getDistance();
			if (distance > 35) { //negates any distances further than 35cm
				distance = 0;
			}
			if (distance > largest) { //finds largest distance amongst distances found (except those above 35)
			largest = distance;
			angle = degree; //saves degree value of largest distance
			}
		}
		Motor.B.rotate(angle); //rotates to angle of largest distance
		Delay.msDelay(500); //gives time in-between stopping at angle and moving
		Motor.B.resetTachoCount(); //resets tacho count so it can return to this location
		while (sonar.getDistance() > 6) { //stops 7cm in front of cup
			Motor.B.forward();
			Motor.C.forward();
			degree = Motor.B.getTachoCount(); //saves degrees traveled to cup
		}
		Motor.B.stop();
		Motor.C.stop();
		while (!(sound.readValue() > 50)) { //waits for sound before going back
		}
		Motor.B.rotate(-degree, true); //rotates robot back to location upon reseting tacho count	
		Motor.C.rotate(-degree); //first rotate is true so both wheels are simultaneous (backwards movement) but wait for robot to finish backing up
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}