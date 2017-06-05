package com.mydomain;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;	
public class Rotation {

	public static void main(String[] args) {
		LCD.drawString("Accurate Rotation Control", 0, 0);
		Button.waitForAnyPress();
		Motor.B.rotate(1440);
		LCD.drawString(Motor.B.getTachoCount() + "", 0, 1);
		Motor.B.rotateTo(0);
		LCD.drawString(Motor.B.getTachoCount() + "", 0, 2);
		Button.waitForAnyPress();

	}

}
