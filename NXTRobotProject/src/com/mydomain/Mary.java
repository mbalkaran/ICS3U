package com.mydomain;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;

public class Mary {

	public static void main(String[] args) {
			Sound.setVolume(1000);
			Sound.playNote(Sound.PIANO, 220, 400);
			Sound.playNote(Sound.PIANO, 196, 400);
			Sound.playNote(Sound.PIANO, 175, 400);
			Sound.playNote(Sound.PIANO, 196, 400);
			Sound.playNote(Sound.PIANO, 220, 400);
			Sound.playNote(Sound.PIANO, 220, 400);
			Sound.playNote(Sound.PIANO, 220, 800);
			Sound.playNote(Sound.PIANO, 196, 400);
			Sound.playNote(Sound.PIANO, 196, 400);
			Sound.playNote(Sound.PIANO, 196, 800);
			Sound.playNote(Sound.PIANO, 220, 400);
			Sound.playNote(Sound.PIANO, 220, 400);
			Sound.playNote(Sound.PIANO, 220, 800);
	}

}
