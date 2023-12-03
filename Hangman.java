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
    	
    	int randNumber = randNum.nextInt(0, 1);
    	
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
    
    
	// main punction is this.
	// its obligations is to play the game while lives exists for user
	
    private void playWhileLivesExists(String listWord, String dashWord){
    	
    	while(gameOn){
    		
    		String ch = readLine("Enter your guess: ");
    		
    		if(listWord.contains(ch)){
    			char guess = ch.charAt(0);
    			updateDash(guess);

    		}else {
    		    livesPerTry--;
    		    println("Incorrect guess! Lives remaining: " + livesPerTry);
    		    HangmanCanvas object = new HangmanCanvas();
    		    object.noteIncorrectGuess();
    	    	if(livesPerTry <= 0){
    	    		gameOn = false;
    	    		println("You lose a Game");
    	    	}
    		}
    	}
    }
    
    
    
    // takes guess char of user and checks if char exists in listWord.
    // for example: when BUOY is a word and guess is B,
    // it will update like B---;
    
    private void updateDash(char guess) {
    	
        char[] updatedDash = dashWord.toCharArray(); // converts dash into char array.

        for (int i = 0; i < listWord.length(); i++) {
            if (listWord.charAt(i) == guess) {
                updatedDash[i] = guess;
            }
        }
        dashWord = new String(updatedDash);
        println("Correct guess! Your world now looks like this: " + dashWord);
    }


}
