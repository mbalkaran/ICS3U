package com.mydomain;

import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;	
import lejos.nxt.LightSensor;	

public class Light {

	public static void main(String[] args) {
		LightSensor light = new LightSensor(SensorPort.S2);
		while (Button.readButtons()!=1) {
			if (light.getLightValue() < 34) {
			Motor.B.forward();
			Motor.C.forward();
			}
			else {
				Motor.B.stop();
				Motor.C.forward();
			}
		}
	}
}

