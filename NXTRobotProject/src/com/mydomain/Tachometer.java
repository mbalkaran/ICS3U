package com.mydomain;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.LCD;
//import lejos.nxt.Delay;
public class Tachometer {

	public static void main(String[] args) {
		LCD.drawString("Program 2", 0, 0);
		Motor.B.setSpeed(720);
		Motor.B.forward();
		Delay.msDelay(2000);
		LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
		Motor.B.stop();
		LCD.drawInt(Motor.B.getTachoCount(), 0, 2);	
		Motor.B.backward();
		while (Motor.B.getTachoCount() > 0) {
		}
		Motor.B.stop();
		LCD.drawInt(Motor.B.getTachoCount(), 0, 3);
		Motor.B.stop();
		LCD.drawInt(Motor.B.getTachoCount(), 0, 4);
		Button.waitForAnyPress();
	}

}
