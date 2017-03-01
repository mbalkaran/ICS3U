package theLifeOfMonique;

import hsa_new.Console;

/**
* AdventureGame.java
* 
* 27/02/2017
* @author Victoria Carroll, Angela Chow, Matthew Balkaran 
*/

public class AdventureGame {

	public static void main(String[] args) {
		Console c = new Console();
		//First Choice = Name is Monique -- Loop
		c.println("Your name is Monique, is this okay? (Yes/No)");
		String userReply;
		userReply = c.readString();
		if (userReply.equalsIgnoreCase("No")){
			while (userReply.equalsIgnoreCase("No")){
				c.println("The game is called 'A Day in the Life of Monique'... Is this okay? (Yes/No)");
				userReply = c.readString();
			}
		}
			do {
			c.clear();
			if (userReply.equalsIgnoreCase("Apologize")){
				c.println("You're forgiven :)");
			}
			c.println("Today is your first day of grade 12. Do you complain to your parents about");
			c.println("making you switch schools or go down for breakfast? (Complain/Breakfast)");
			userReply = c.readString();
			if (userReply.equalsIgnoreCase("Complain")) {
				c.clear();
				c.println("You are NOT getting a drive!! - Mom. Would you like to continue complaining or");
				c.println("apologize? (Complain/Apologize)");
				userReply = c.readString();
				if (userReply.equalsIgnoreCase("Complain")){
					c.print("You are late to school but it's okay. You go to the office to get your locker combo. It will be: ");
					int[]lockerCode = new int[4];
					for (int i = 0; i < lockerCode.length; i++) {
						lockerCode[i] = (int)(Math.random()*9);
						c.print(lockerCode[i]);
					}
					c.println("");
					c.println("Brittany approaches you seeing that you are lost. What is your next class? (Phys.Ed/Calculus)");
					userReply = c.readString();
					if (userReply.equalsIgnoreCase("Phys.Ed")){
						c.clear();
						c.println("You meet a boy named Troy. You fall madly in love and the school is obliterated");
					}
					else if (userReply.equalsIgnoreCase("Calculus")){
						c.clear();
						c.println("Awh this class is boring but you meet a cute boy named Chad!");
						c.println("Chad offers to help you with homework. Do you say yes??? (Yes/No)");
						userReply = c.readString();
						// do if statement tmrw
					}
					
				}
			}
			} while (userReply.equalsIgnoreCase("Apologize"));
	}
	 
}
