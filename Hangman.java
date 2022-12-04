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
    	int randNumber = randNum.nextInt(0, 9);
    	
    	gameWord = word.getWord(randNumber); // getting random word according to randNumber value;
    	
    	String deshWord = changeWordWithDesh(gameWord); // returning desh word with length of word;
    	
    	println(deshWord);
  
		
    	while(gameOn){
    		
    		int counter = 0;
    		
    		char userChar = usersChar(); // converting string to char and returns it
    		
    		println(userChar);
    		
    		giveMeNewDesh(userChar);
    		
    		
    		println("The word now looks like this: ");
    		
    		counter++;
    		
    		if(counter == 20){
    			break;
    		}
    		
    	}
	}
    
    
    
    private char usersChar() {
		String userStringChar = readLine("Your guess: "); // getting single letter string
		
		char userChar = userStringChar.charAt(0);
		
		return userChar;
	}



	private String changeWordWithDesh(String gameWord){  // changes words with desh examples -->   hello -- > "-----"
    	int wordLength = gameWord.length();
    	
    	String deshWord = "";
    	
    	for(int i = 0; i < wordLength; i++){
    		
    		deshWord = deshWord +  "-";
    	}
    	
    	return deshWord;
    	
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
