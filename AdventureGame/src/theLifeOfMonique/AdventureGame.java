package theLifeOfMonique;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import hsa_new.Console;

/**
 * AdventureGame.java
 * This program follows a high school senior, Monique, at her new high school. The user plays as Monique and experiences different events based on their choices.
 * 27/02/2017
 * @author Victoria Carroll, Angela Chow, Matthew Balkaran 
 */

public class AdventureGame {

	public static void main(String[] args) {
		Console c = new Console(20, 70, 16, "A Day in the Life of Monique"); //console size & fontsize TBD
		int playAgainLoop = 1;
		BufferedImage pngImage = null;
		while (playAgainLoop == 1) {
			//First Choice = Asks if user is okay with their name being Monique, if they say no, it loops until they say yes.
			c.println("Your name is Monique, is this okay? (Yes/No)");
			try {
				pngImage = ImageIO.read(new File("adventure game pics/characters.png"));
			} catch (IOException e) {
				System.err.println("There was an error loading the image.");
				e.printStackTrace();
			}
			c.drawImage (pngImage, 200, 140, 500, 250, null); //picture dimensions TBD
			String userReply;
			userReply = c.readString();
			if (userReply.equalsIgnoreCase("No")){
				while (!userReply.equalsIgnoreCase("Yes")){
					c.println("The game is called 'A Day in the Life of Monique'... Is this okay? (Yes/No)");
					userReply = c.readString();
				}
			}
			else if (userReply.equalsIgnoreCase("Yes")) {
				do { //This loops allows the user to repeat their choice if they decide to apologize to their parents after complaining.
					c.clear();
					if (userReply.equalsIgnoreCase("Apologize")){
						c.println("You're forgiven :)");
					}
					c.println("Today is your first day of grade 12. Do you complain to your parents about making you switch schools or go down for breakfast? \n(Complain/Breakfast)");
					userReply = c.readString();
					if (userReply.equalsIgnoreCase("Breakfast")) {
						c.clear();
						c.println("Would you like to get a drive or bike to school? (Bike/Drive)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Bike")) {
							c.clear();
							c.println("Would you like to take the safe way or the dangerous way? (Safe/Dangerous)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Dangerous")) {
								int RNG1 = (int)(Math.random()*9 + 1);
								if (RNG1 < 6) {
									c.clear();
									c.println("It was a dream."); 
								}
								else {
									c.clear();
									c.println("You fall in a ditch.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
							}
							else if (userReply.equalsIgnoreCase("Safe")) {
								c.clear();
								c.println("You go to the office to get your locker code.");
								c.println("INTENSE! The student president vote is a tie.");
								c.println("As the new girl you have the last vote.");
								c.println("Do you vote for the nice student president or the mean student president? (Nice/Mean).");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Nice")) {
									c.println("WOW! AMAZING! YOU MEET JACOB SATORIUS!! WOOHOO!"); //Play Sweatshirt
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
								else if (userReply.equalsIgnoreCase("Mean")) {
									c.println("VAMPIRE ATTACK! oh no! Luckily it was Edward. #togetherforever");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
								else {
									c.clear();
									c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
							}
							else {
								c.clear();
								c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
								}
								else {
									playAgainLoop = 2;
									c.close();
								}
							}
						}
						else if (userReply.equalsIgnoreCase("Drive")) {
							c.clear();
							c.println("Your mom embarrasses you. Brittany makes fun of you. What do you do? (Fight/Ignore)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Ignore")) {
								c.clear();
								c.println("Your high school expreience sucks. Don't be a loser");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
								}
								else {
									playAgainLoop = 2;
									c.close();
								}
							}
							else if (userReply.equalsIgnoreCase("Fight")) {
								c.clear();
								c.println("Would you like to pull her hair or kick her? (Pull/Kick)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Kick")){
									c.clear();
									c.println("You lost the fight. #loser :(");
									//insert the boo sound
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
								else if (userReply.equalsIgnoreCase("Pull")){
									c.clear();
									c.println("You win the fight and become extremely popular!");
									c.println("Ah wow! You are one lucky gal. Troy and Chad both ask you out. Who do you choose? (Troy/Chad/Both/Neither)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Troy")){
										c.println("UH OH! Troy was dating Brittany. She later finds you and pushes you down the stairs.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Chad")){
										c.clear();
										c.println("You go on a Pizza Hut date and later become the homecoming queen!");	
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Neither")){
										c.clear();
										c.println("How could you do that??? EPIC FAIL!");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Both")){
										c.clear();
										c.println("Both dates went amazingly well! You now have to choose one. You're no player! (Troy/Chad)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Troy")){
											c.clear();
											c.println("You go over to his house to hang out. His cat comes near you and you run because you're allergic and you get hit by a car!");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
										else if (userReply.equalsIgnoreCase("Chad")){
											c.clear();
											do {
												if (userReply.equalsIgnoreCase("No")){
													c.println("What's wrong with you!?");
												}
												c.println("He texts you: 'Do you want to hang out again?'(Yes/No)"); 
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")){
													c.clear();
													if (userReply.equalsIgnoreCase("No")){
														c.println("What's wrong with you!?");
													}
													c.println("Chad proposes! Do you say yes? (Yes/No)");
													userReply = c.readString();
													if (userReply.equalsIgnoreCase("Yes")){
														c.clear();
														c.println("You live happily ever after!");
														c.println("Would you like to play again? (Yes/No)");
														userReply = c.readString();
														if (userReply.equalsIgnoreCase("Yes")) {
															c.clear();
														}
														else {
															playAgainLoop = 2;
															c.close();
														}
													}
													else if (userReply.equalsIgnoreCase("No")){
														c.clear();
													}
													else {
														c.clear();
														c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
														c.println("Would you like to play again? (Yes/No)");
														userReply = c.readString();
														if (userReply.equalsIgnoreCase("Yes")) {
															c.clear();
														}
														else {
															playAgainLoop = 2;
															c.close();
														}
													}
												}
												else if (userReply.equalsIgnoreCase("No")){
													c.clear();
												}
												else {
													c.clear();
													c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
													c.println("Would you like to play again? (Yes/No)");
													userReply = c.readString();
													if (userReply.equalsIgnoreCase("Yes")) {
														c.clear();
													}
													else {
														playAgainLoop = 2;
														c.close();
													}
												}
											} while (userReply.equalsIgnoreCase("No"));
										}
										else {
											c.clear();
											c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
									}
									else {
										c.clear();
										c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
								}
								else {
									c.clear();
									c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
							}
							else {
								c.clear();
								c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
								}
								else {
									playAgainLoop = 2;
									c.close();
								}
							}
						}
						else {
							c.clear();
							c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
							c.println("Would you like to play again? (Yes/No)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Yes")) {
								c.clear();
							}
							else {
								playAgainLoop = 2;
								c.close();
							}
						}
					}
					else if (userReply.equalsIgnoreCase("Complain")) {
						c.clear();
						c.println("You are NOT getting a drive!! - Mom. Would you like to continue complaining or apologize? (Complain/Apologize)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Complain")){
							c.clear();
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
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
								}
								else {
									playAgainLoop = 2;
									c.close();
								}
							}
							else if (userReply.equalsIgnoreCase("Calculus")){
								c.clear();
								c.println("Awh this class is boring but you meet a cute boy named Chad!");
								c.println("Chad offers to help you with homework. Do you say yes??? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")){
									c.clear();
									c.println("Would you like to study at home, the library, or the café? (Home/Library/Cafe)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Library")){
										c.clear();
										c.println("You and Chad become close friends and together learn Latin and move to Peru!");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Cafe")){
										c.clear();
										c.println("Your ex boyfriend is there and he thinks Chad is your boyfriend. They fight and Chad goes to the hospital.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
									else if (userReply.equalsIgnoreCase("Home")){
										int RNG2 = (int)(Math.random()*9 + 1);
										if (RNG2 < 6) {
											c.clear();
											c.println("Your mom comes home and catches you and you're gorunded for a year.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
										else {
											c.clear();
											c.println("Chad asks if you want to go to homecoming and you ace your calculus test.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
									}
									else {
										c.clear();
										c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
								}
								else if (userReply.equalsIgnoreCase("No")){
									c.clear();
									c.println("You decide to call Brittany. Her number is in your locker. What is your locker combination (INPUT EACH NUMBER INDIVIDUALLY)");
									int lockerReply0;
									int lockerReply1;
									int lockerReply2;
									int lockerReply3;
									lockerReply0 = c.readInt();
									lockerReply1 = c.readInt();
									lockerReply2 = c.readInt();
									lockerReply3 = c.readInt();
									if (lockerReply0 == lockerCode[0] && lockerReply1 == lockerCode[1] && lockerReply2 == lockerCode[2] && lockerReply3 == lockerCode[3]){
										c.clear();
										c.println("She invites you to a party tonight. Do you go? (Yes/No)");
										userReply = c.readString();
										if(userReply.equalsIgnoreCase("No")){
											c.clear();
											c.println("Wrong choice! Always Party!");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
										else if (userReply.equalsIgnoreCase("Yes")){
											c.clear();
											c.println("The party is amazing!! Troy offers you a drink. Do you take it? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("No")){
												c.clear();
												c.println("You survive! Congratulations, high school is great!");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													c.clear();
												}
												else {
													playAgainLoop = 2;
													c.close();
												}
											}
											else if (userReply.equalsIgnoreCase("Yes")){
												c.clear();
												c.println("You are caught! The police come and you are charged with embezzelment.");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													c.clear();
												}
												else {
													playAgainLoop = 2;
													c.close();
												}
											}
											else {
												c.clear();
												c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
												c.println("Would you like to play again? (Yes/No)");
												userReply = c.readString();
												if (userReply.equalsIgnoreCase("Yes")) {
													c.clear();
												}
												else {
													playAgainLoop = 2;
													c.close();
												}
											}
										}
										else {
											c.clear();
											c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
											c.println("Would you like to play again? (Yes/No)");
											userReply = c.readString();
											if (userReply.equalsIgnoreCase("Yes")) {
												c.clear();
											}
											else {
												playAgainLoop = 2;
												c.close();
											}
										}
									}
									else {
										c.clear();
										c.println("You spend your night at home studying... high school sucks and you're a failure");
										c.println("Would you like to play again? (Yes/No)");
										userReply = c.readString();
										if (userReply.equalsIgnoreCase("Yes")) {
											c.clear();
										}
										else {
											playAgainLoop = 2;
											c.close();
										}
									}
								}
								else {
									c.clear();
									c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
									c.println("Would you like to play again? (Yes/No)");
									userReply = c.readString();
									if (userReply.equalsIgnoreCase("Yes")) {
										c.clear();
									}
									else {
										playAgainLoop = 2;
										c.close();
									}
								}
							}
							else {
								c.clear();
								c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
								c.println("Would you like to play again? (Yes/No)");
								userReply = c.readString();
								if (userReply.equalsIgnoreCase("Yes")) {
									c.clear();
								}
								else {
									playAgainLoop = 2;
									c.close();
								}
							}
						}
						else if (userReply.equalsIgnoreCase("Apologize")){
							// This else if is here so that if they decided to apologize, it does not load the else ending for when they incorrectly spell their choice.
						}
						else {
							c.clear();
							c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
							c.println("Would you like to play again? (Yes/No)");
							userReply = c.readString();
							if (userReply.equalsIgnoreCase("Yes")) {
								c.clear();
							}
							else {
								playAgainLoop = 2;
								c.close();
							}
						}
					}
					else {
						c.clear();
						c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
						c.println("Would you like to play again? (Yes/No)");
						userReply = c.readString();
						if (userReply.equalsIgnoreCase("Yes")) {
							c.clear();
						}
						else {
							playAgainLoop = 2;
							c.close();
						}
					}
				} while (userReply.equalsIgnoreCase("Apologize")); // This is the end of what is contained in the loop. It goes back to do if they decided to apologize.
			}
			else {
				c.clear();
				c.println("Wow, you clearly don't know how to read. Next time, be careful with your spelling.");
				c.println("Would you like to play again? (Yes/No)");
				userReply = c.readString();
				if (userReply.equalsIgnoreCase("Yes")) {
					c.clear();
				}
				else {
					playAgainLoop = 2;
					c.close();
				}
			}
		}
	}
}