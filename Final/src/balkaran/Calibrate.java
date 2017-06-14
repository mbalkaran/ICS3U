package balkaran;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Calibrate implements Behavior {
	private boolean suppressed = false;
	private LightSensor light = new LightSensor(SensorPort.S2);
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {
		if (light.getLightValue() > 33) {
			return true;
		}
		return false;
	}
	public void action() {
		suppressed = false;
		Motor.C.rotate(1440);
		Motor.B.rotate(1440);
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}
