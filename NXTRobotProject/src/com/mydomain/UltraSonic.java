package com.mydomain;

import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.UltrasonicSensor;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;

public class UltraSonic {
	public static void main(String[] args) {
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);
		while (Button.readButtons()!=1) {
			Motor.B.forward();
			Motor.C.forward();
			sonar.ping();
			Delay.msDelay(20);
			if (sonar.getDistance() == 25) {
				Motor.B.backward();
				Motor.C.backward();
				Delay.msDelay(1000);
				Motor.B.stop();
				Motor.C.stop();
				Motor.B.rotate(360);
			}
		}
	}
}

