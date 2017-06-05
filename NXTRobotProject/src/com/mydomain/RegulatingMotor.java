package com.mydomain;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;
public class RegulatingMotor {

	public static void main(String[] args) {
		LCD.drawString("Program 5", 0, 0);
		Button.waitForAnyPress();
		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);
		for (int i = 0; i < 8; i++) {
			Motor.B.rotate(720, true);
			Motor.C.rotate(720, true);
			for (int x = 0; x < 5; x++) {
				Delay.msDelay(200);
				LCD.drawString(Motor.B.getTachoCount() + " " + Motor.C.getTachoCount() + "        ", 0, i);
			}
			Motor.B.stop();
			Motor.C.stop();
			Button.waitForAnyPress();
		}
	}
}
