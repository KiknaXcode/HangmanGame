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
	
	boolean gameOn = false;
	
	
	
    public void run() {
    	
    	
    	// in first case, we need to take word from list
    	int randNumber = randNum.nextInt(0, 9);
    	String gameWord = word.getWord(randNumber);
    	
    	changeWordWithDesh(gameWord); // returning desh word with length of word;
    	
		
    	while(gameOn){
    		
    		usersChar();
    		
    		
    		println("The word now looks like this: ");
    		
    	}
	}
    
    
    
    private void usersChar() {
		String userChar = readString("Your guess: ");
		int user = readInt("!");
		
	}



	private String changeWordWithDesh(String gameWord){
    	int wordLength = gameWord.length();
    	
    	String deshWord = "";
    	
    	for(int i = 0; i < wordLength; i++){
    		
    		deshWord = deshWord +  "-";
    	}
    	
    	return deshWord;
    	
    	
    }

}
