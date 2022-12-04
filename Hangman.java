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
	
	
	
    public void run() {
    	
    	
    	// in first case, we need to take word from list
    	int randNumber = randNum.nextInt(0, 2);
    	
    	gameWord = word.getWord(randNumber); // getting random word according to randNumber value;
  
		
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
    
    
    
    private char usersChar() {
		String userStringChar = readLine("Your guess: "); // getting single letter string
		
		userStringChar = userStringChar.toUpperCase();
		
		char userChar = userStringChar.charAt(0);
		
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


}
