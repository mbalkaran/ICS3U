package balkaran;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;

public class Movement implements Behavior {
	private boolean suppressed = false;
	private LightSensor light = new LightSensor(SensorPort.S2);
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {
		return true;
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
