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
    	
    	changeWordWithDesh(gameWord);
    	
		
    	while(gameOn){
    		println("The word now looks like this: ");
    		
    	}
	}
    
    String deshWord; 
    
    private void changeWordWithDesh(String gameWord){
    	int wordLength = gameWord.length();
    	
    	for(int i = 0; i < wordLength; i++){
    		deshWord = "";
    		deshWord += "-";
    	}
    	
    	println(deshWord);
    	
    	
    }

}
