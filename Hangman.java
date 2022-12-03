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
    	
    	gameWord = word.getWord(randNumber);
    	
    	String deshWord = changeWordWithDesh(gameWord); // returning desh word with length of word;
  
		
    	while(gameOn){
    		
    		char userChar = usersChar(); // converting string to char and returns it
    		
    		checkWord(userChar);
    		
    		
    		println("The word now looks like this: ");
    		
    		break;
    		
    	}
	}
    
    
    
    private char usersChar() {
		String userStringChar = readLine("Your guess: ");
		
		char userChar = userStringChar.charAt(0);
		
		return userChar;
	}



	private String changeWordWithDesh(String gameWord){
    	int wordLength = gameWord.length();
    	
    	String deshWord = "";
    	
    	for(int i = 0; i < wordLength; i++){
    		
    		deshWord = deshWord +  "-";
    	}
    	
    	return deshWord;
    	
    }
	
	private void checkWord(char userChar){
		for(int i = 0; i < gameWord.length(); i++){
			if(gameWord.charAt(i) == userChar){
				int indexOfChar = gameWord.indexOf(userChar);
				
				String chagnedDeshWord = changeDeshWord(indexOfChar, userChar); // returning changed version of deshWord
				
				println(chagnedDeshWord);
				
				
			}else{
				println("no no");
			}
		}
	}
	
	private String changeDeshWord(int indexOfChar, char userChar){
    	int wordLength = gameWord.length();
    	
    	String newDeshWord = "";
    	
    	for(int i = 0; i < wordLength; i++){
    		
    		if(i == indexOfChar){
    			newDeshWord = newDeshWord +  userChar;
    		}else{
    			newDeshWord = newDeshWord +  "-";
    		}
    		
    	}
    	
    	return newDeshWord;
   
		
	}

}
