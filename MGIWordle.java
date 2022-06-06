import java.util.Scanner;

/*
 * MGIWordle.java
 * Author:  Eleanor aka "bug"
 * Creation Date: 06/05/2022
 * Last Edit Date: 06/06/2022
 * Time Spent: too much
 *
 * Purpose: Wordle. But for the MGI 
 * Discord server. idk.
 */

public class MGIWordle {

	public static void main(String[] args) {
		//initialize variables 
		String wordAnswer, userInput;
		String inputOne, inputTwo, inputThree, inputFour, inputFive;
		String answerOne, answerTwo, answerThree, answerFour, answerFive;
		int round, randomNumber, numberOfGreen;
		boolean endGame = false;
		String[] wordBank = {"angst", "bruce", "jason", "arson", "black", 
		"night", "crime", "chaos", "steal", "thief", "noods", "paris", 
		"lucky", "charm", "write", "batty", "wayne", "drake", 
		"spell", "magic", "power", "wound", "stole", "steal", "blood", 
		"grime", "joker", "scare", "scary", "money", "robin", "clark", "diana"};
		
		
		//print instructions
		System.out.println("Hi! Welcome to Bug's very own Special "
				+ "Verson of Wordle!!!");
		System.out.println("Instructions: \tPlay as you would "
				+ "a normal Wordle game.");
		
		//get random word from word bank:
		//get random number
		randomNumber = (int) (Math.random() * wordBank.length);
		//find word based on random number 
		wordAnswer = wordBank[randomNumber];
		//separate each character
		answerOne = wordAnswer.substring(0,1);
		answerTwo = wordAnswer.substring(1,2);
		answerThree = wordAnswer.substring(2,3);
		answerFour = wordAnswer.substring(3,4);
		answerFive = wordAnswer.substring(4,5);
		
		//define and create a scanner object -- keyboard input
		Scanner keyboard = new Scanner(System.in);
		round = 0;
			
		//loop until answer is found 
		while (endGame == false) {
			System.out.println("Round: " + round);
			//prompt for user input
			System.out.println("Enter word guess here:\t");
			userInput = keyboard.nextLine();
		
			//reset variable
			numberOfGreen = 0;
				
			//check for proper input
			if (userInput.length() != 5) {
				System.out.println("I said FIVE letters. Don't you know how to count?");
			}
			else {
				//separate each character
				inputOne = userInput.substring(0,1);
				inputTwo = userInput.substring(1,2);
				inputThree = userInput.substring(2,3);
				inputFour = userInput.substring(3,4);
				inputFive = userInput.substring(4,5);
					
				//determine if the correct letter is placed in the correct space (GREEN)
				//print user results
				System.out.println("Green Letters:");
				//input one
				if (inputOne.equals(answerOne)) {
					System.out.println(inputOne);
					numberOfGreen += 1;
				}
				//input two
				if (inputTwo.equals(answerTwo)) {
					System.out.println(inputTwo);
					numberOfGreen += 1;
				}
				//input three
				if (inputThree.equals(answerThree)) {
					System.out.println(inputThree);
					numberOfGreen += 1;
				}
				//input four
				if (inputFour.equals(answerFour)) {
					System.out.println(inputFour);
					numberOfGreen += 1;
				}
				//input five
				if (inputFive.equals(answerFive)) {
					System.out.println(inputFive);
					numberOfGreen += 1;
				}
					
				//determine if a letter is used but in the incorrect spot (YELLOW)
				System.out.println("\nYellow Letters:");
				//input one
				if ( (inputOne.equals(answerTwo)) || (inputOne.equals(answerThree))
				|| (inputOne.equals(answerFour)) || (inputOne.equals(answerFive)) ) {
					System.out.println(inputOne);
				}
				//input two
				if ( (inputTwo.equals(answerOne)) || (inputTwo.equals(answerThree))
				|| (inputTwo.equals(answerFour)) || (inputTwo.equals(answerFive)) ) {
					System.out.println(inputTwo);
				}
				//input three
				if ( (inputThree.equals(answerTwo)) || (inputThree.equals(answerOne))
				|| (inputThree.equals(answerFour)) || (inputThree.equals(answerFive)) ) {
					System.out.println(inputThree);
				}
				//input four
				if ( (inputFour.equals(answerTwo)) || (inputFour.equals(answerThree))
				|| (inputFour.equals(answerOne)) || (inputFour.equals(answerFive)) ) {
					System.out.println(inputFour);
				}
				//input five
				if ( (inputFive.equals(answerTwo)) || (inputFive.equals(answerThree))
				|| (inputFive.equals(answerFour)) || (inputFive.equals(answerOne)) ) {
					System.out.println(inputFive);
				}
					
				//another round complete
				round += 1;
					
				//game over -- lose
				if (round == 6) {
					System.out.print("Sorry! You're out of turns. Better luck next time.");
					endGame = true;
				}
					
				//word is correct
				if (numberOfGreen == 5) {
					System.out.print("You got the word! Congrats!!");
					endGame = true;
					System.exit(0);
				}
			}	
		}
		//close keyboard 
		keyboard.close();
	}
}