package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;

public class Stuff1 {

	public static void main(String[] args) {
		// Motor.B.setSpeed(360);
		// Motor.C.forward();
		// Motor.C.setSpeed(360);
		// Motor.C.forward();
		for (int i = 0; i < 2; i++) {
			Sound.playNote(Sound.PIANO,2400,34);
			Sound.playNote(Sound.PIANO,4800,50);
			Sound.playNote(Sound.PIANO,3840,750);
			Sound.playNote(Sound.PIANO,858,950);
			Sound.playNote(Sound.FLUTE,1400,200);
			Sound.playNote(Sound.FLUTE,880,500);
			Sound.playNote(Sound.FLUTE,784,250);
			Sound.playNote(Sound.FLUTE,880,250);
			Sound.playNote(Sound.XYLOPHONE,880,250);
			Sound.playNote(Sound.XYLOPHONE,784,250);
			Sound.playNote(Sound.XYLOPHONE,880,500);
			Sound.playNote(Sound.XYLOPHONE,4400,500);
		}
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		if (touch.isPressed()) {
			Motor.B.stop();
			Motor.C.stop();
		}
		Button.waitForAnyPress();
		
	}
}
