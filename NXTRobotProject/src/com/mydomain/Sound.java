package com.mydomain;

import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.SoundSensor;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;	

public class Sound {

	public static void main(String[] args) {
		SoundSensor sound = new SoundSensor(SensorPort.S3, true);
		Motor.B.forward();
		Motor.C.forward();
		int t = 0;
		int i = 360;
		while (Button.readButtons()!=1) {
			t = 0;
			for (int x = 0; x < 5; x++) {
				if (sound.readValue() > 50) {
					t++;
				}
				Delay.msDelay(600);
			}
			if (t >= 2) {
				Motor.B.stop();
				Motor.C.stop();
			}
			else {
				i = i + 360;
				Motor.B.setSpeed(i);
				Motor.C.setSpeed(i);
			}
		}
	}
}

	/*
		int i;
		while (Button.readButtons() != 1) {
			if (sound.readValue()>40) {
				Motor.B.stop();
				Motor.C.stop();
				i = 0;
				if (sound.readValue() > 50) {
					i++;
				}
				Delay.msDelay(500);
				if (sound.readValue() > 50) {
					i++;
				}
				if (i==1) {
					Motor.B.rotate(720);
				}
				else if (i==2) {
					Motor.C.rotate(720);
				}
			}
		}
		*/