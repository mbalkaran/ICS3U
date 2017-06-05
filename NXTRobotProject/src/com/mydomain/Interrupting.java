package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;

public class Interrupting {

	public static void main(String[] args) {
		LCD.drawString("Program 4", 0, 0);
		Button.waitForAnyPress();
		Motor.B.rotate(-1440, true);
		Delay.msDelay(200);
		while (Motor.B.isMoving()) {
			LCD.drawString(Motor.B.getTachoCount() + "", 0, 1);
			if (Button.readButtons()>0) {
				Motor.B.stop();
			}
		}
		LCD.drawString(Motor.B.getTachoCount() + "", 0, 2);
		Button.waitForAnyPress();
	}
}
