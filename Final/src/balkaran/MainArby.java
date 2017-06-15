package balkaran;

import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

/**
 * MainArby.java
 * Executes baseball programs - follows path, finds furtherest object each base, and returns home
 * 06/14/2017
 * @author Matthew Balkaran
 */

public class MainArby {
	
/**
 * This method is the main method that contains all the behaviors and their priorities
 * @return no return, main method
 * @param args
 */
	
	public static void main(String[] args) {
		LightSensor light = new LightSensor(SensorPort.S2);
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
		SoundSensor sound= new SoundSensor(SensorPort.S3);
		Behavior b3 = new ExitProgram(); //highest priority
		Behavior b2 = new Scan(sonar, sound, light);
		Behavior b1 = new Calibrate(light);
		Behavior b0 = new Movement(); //lowest priority
		Behavior[] behaviors = {b0, b1, b2, b3};
		
		Arbitrator arby = new Arbitrator(behaviors);
		arby.start();
	}

}