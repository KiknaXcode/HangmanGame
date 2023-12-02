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
	
	private String listWord;
	
	private String dashWord;
	
	int livesPerTry = 8;
	
    public void run() {
    	
    	println("Welcome to Hangman");
    	
    	listWord = takeWordFromList();
    	
    	dashWord = convertWordIntoDash(listWord);
    	
    	println(dashWord);
    	
    	playWhileLivesExists(listWord, dashWord); // give user right to guess numbers while lives exists

    	

	}
    	// println("You have " + livesPerTry + " guessess left.");
    

    
    // in first case, we need to take word from list
    // returns random string from list of Lexicon
    private String takeWordFromList(){
    	
    	int randNumber = randNum.nextInt(0, 10);
    	
    	listWord = word.getWord(randNumber); // getting random word according to randNumber value;
    	
    	return listWord;
    }
    
    
    // takes String like "COMPUTER" and converts it into dash representation
    // and then returns it.
    // for example: "COMPUTER" --> "--------"
    
	private String convertWordIntoDash(String listWord){
		
		String deshWord = "";
		
		for(int i = 0; i < listWord.length(); i++){
			deshWord = deshWord +  "-";
		}
		
		return deshWord;
		
	}	
    
    
	
	
    private void playWhileLivesExists(String listWord, String dashWord){
    	
    	// while(gameOn){
    		
    		String ch = readLine("Enter your guess: ");
    		
    		if(listWord.contains(ch)){
    			updateDash(ch);
    		}
    }
    
    private void updateDash(char guess) {
        StringBuilder updatedDash = new StringBuilder(dashWord);

        for (int i = 0; i < listWord.length(); i++) {
            if (listWord.charAt(i) == guess) {
                updatedDash.setCharAt(i, guess);
            }
        }

        dashWord = updatedDash.toString();
    }

    
    
    
    

}
