package balkaran;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class test {

	public static void main(String[] args) {
		LightSensor light = new LightSensor(SensorPort.S2);
		Button.waitForAnyPress();
		LCD.drawInt(light.getLightValue(), 0, 1);
		Button.waitForAnyPress();
		LCD.drawInt(light.getLightValue(), 0, 2);
		Button.waitForAnyPress();
		LCD.drawInt(light.getLightValue(), 0, 3);
		Button.waitForAnyPress();
		LCD.drawInt(light.getLightValue(), 0, 4);
		Button.waitForAnyPress();
		LCD.drawInt(light.getLightValue(), 0, 5);
	}

}
