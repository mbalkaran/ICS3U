package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.util.Delay;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;

public class Touch {

	public static void main(String[] args) {
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);
		Sound.setVolume(1000);
		while (Button.readButtons()!=1) {
			Motor.B.backward();
			Motor.C.backward();
			if (touch.isPressed()) {
				Motor.B.forward();
				Motor.C.forward();
				Sound.playNote(Sound.PIANO,220,330);
				Sound.playNote(Sound.PIANO,320,430);
				Sound.playNote(Sound.PIANO,420,530);
			}
		}

	}

}
