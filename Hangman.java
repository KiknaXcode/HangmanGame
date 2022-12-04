/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	
	private RandomGenerator randNum = RandomGenerator.getInstance();
	private HangmanLexicon word = new HangmanLexicon();
	
	boolean gameOn = true;
	
	String gameWord;
	
	int livesPerTry = 8;
	
	
	
    public void run() {
    	
    	println("Welcome to Hangman");
    	
    	
    	// in first case, we need to take word from list
    	int randNumber = randNum.nextInt(0, 1);
    	
    	gameWord = word.getWord(randNumber); // getting random word according to randNumber value;
    	
    	println(gameStartWord());
    	
    	println("You have " + livesPerTry + " guessess left.");
    	
    	
  
		
    	while(gameOn){
    		
    		int counter = 0;
    		
    		char userChar = usersChar(); // converting string to char and returns it
    		
    		
    		println(userChar);
    		
    		String exitingWord = giveMeNewDesh(userChar); // changes desh --> "-----" => "--S--";
    		
    		
    		println("The word now looks like this: " + exitingWord);
    		
    		counter++;
    		
    		if(counter == 20){
    			gameOn = false;
    		}
    		
    	}
	}
    
    
    
    
    char userChar;
    
    private char usersChar() {
    	
    	boolean incorrectChar = true;
    	
    	while(incorrectChar){
    		
    		String userStringChar = readLine("Your guess: "); // getting single letter string
    		
    		userStringChar = userStringChar.toUpperCase();
    		
    		userChar = userStringChar.charAt(0);
    		
    		incorrectChar = checkCharType(userChar);
    		
    		println("hello)");
    		
    		printingSystem(incorrectChar);
    		
    	}
    	
    	return userChar;

	}



	
	private String giveMeNewDesh(char userChar){
		
		String newDeshWord = "";
		
		for(int i = 0; i < gameWord.length(); i++){
			
			if(gameWord.charAt(i) == userChar){
				
				newDeshWord = newDeshWord +  userChar;
				
			}else{
				
				newDeshWord = newDeshWord +  "-";
	    	
				// String changedDeshWord = changeDeshWord(indexOfChar, userChar); // returning changed version of deshWord
			}
			
		}
		
		return newDeshWord;
		
		
		
	}	
	
	private boolean checkCharType(char userChar){  // checks if charachter is letter or not
		if(Character.isLetter(userChar)){
			return false;
		}else{
			
			return true;
		}
		
	}
	
	
	private String gameStartWord(){
		String deshWord = "";
		
		for(int i = 0; i < gameWord.length(); i++){		
				deshWord = deshWord +  "-";	
		}
		return deshWord;
	}
	
	private void printingSystem(boolean printLogic){
		if(printLogic){
			println("There are no chosen Letter in the word");
	    	livesPerTry--;
	    	println("You have " + livesPerTry + " guessess left.");
		}
	}
		
		


}
