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
		Motor.B.rotate(360, true);
		Delay.msDelay(3000);
		Motor.C.rotate(720, true);
		Delay.msDelay(6000);
		Motor.B.rotate(1080, true);
		Delay.msDelay(9000);
		Motor.C.rotate(1440, true);
		Delay.msDelay(12000);
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}
