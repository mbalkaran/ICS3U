package balkaran;

import hsa_new.Console;

/**
* HelloConsole.java
* The program prints Hello to a new console and ask to user to pick a class. 
* The program assigns stats to the user based on their chosen class.
* 24/02/2017
* @author Matthew Balkaran
*/

public class HelloConsole {

	public static void main(String[] args) {
		Console c = new Console();
		c.println("Hello");
		c.println("Pick a player class: Warrior, Mage, or Healer?");
		String PlayerClass;
		PlayerClass = c.readString();
		if (PlayerClass.equals("Warrior")) {
			c.println("You picked Warrior. Your stats are:");
			c.println("Strength: 14");
			c.println("Dexterity: 8");
			c.println("Resistance: 10");
			c.println("Intelligence: 5");
			c.println("Faith: 3");
		}
		else if (PlayerClass.equals("Mage")) {
			c.println("You picked Mage. Your stats are:");
			c.println("Strength: 3");
			c.println("Dexterity: 6");
			c.println("Resistance: 8");
			c.println("Intelligence: 14");
			c.println("Faith: 8");
		}
		else if (PlayerClass.equals("Healer")) {
			c.println("You picked Healer. Your stats are:");
			c.println("Strength: 2");
			c.println("Dexterity: 8");
			c.println("Resistance: 11");
			c.println("Intelligence: 7");
			c.println("Faith: 18");
		}
		else {
			c.println("You picked nothing.");
			c.println("You will be punished for your indesiveness. Your stats are:");
			c.println("Strength: 1");
			c.println("Dexterity: 1");
			c.println("Resistance: 1");
			c.println("Intelligence: 1");
			c.println("Faith: 1");
		}                             
	}

}
