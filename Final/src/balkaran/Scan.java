package balkaran;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Scan implements Behavior {
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	private boolean suppressed = false;
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {
		return true;
	}
	public void action() {
		int degree = 0;
		int angle = 0;
		int largest = 0;
		int distance = 0;
		Motor.B.rotate(1440, true);
		while (Motor.B.getTachoCount() < 1440) {
			degree = Motor.B.getTachoCount();
			distance = sonar.getDistance();
			if (distance > 100) {
				distance = 0;
			}
			if (distance > largest) {
			largest = distance;
			angle = degree;
			}
		}
		Motor.B.rotate(angle);
		while (!suppressed) {
			Thread.yield();
		}
		Motor.B.stop();
	}
}