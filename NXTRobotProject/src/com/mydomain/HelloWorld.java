package com.mydomain;

import lejos.nxt.Button;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello Cruel World!");
		Button.waitForAnyPress();
	}

}
