package balkaran;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;

public class Spin implements Behavior {
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	private boolean suppressed = false;
	public void suppress() {
		suppressed = true;
	}
	public boolean takeControl() {

	}
	public void action() {
		Motor.B.rotate(360, true);
		int i = 0;
		int[] degree;
		int[] distance;
		while (Motor.B.getTachoCount() < 360) {
			degree[i] = Motor.B.getTachoCount();
			if (sonar.getDistance() < 101) {
			distance[i] = sonar.getDistance();
			}
			else {
				distance[i] = 0;
			}
		}
		
	}
}

