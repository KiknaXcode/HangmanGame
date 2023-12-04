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
	
	// we should presicly define this, instead we will get error
	private static final int LEXICON_MAX_WORD_NUMBER = 120000; 
	
	boolean gameOn = true;
	
	private String listWord;
	
	private String dashWord;
	
	int livesPerTry = 6;
	
	private HangmanCanvas canvas;
	
	
    public void init() { 
    	canvas = new HangmanCanvas(); 
    	add(canvas); 
    	
    } 
	
    public void run() {
    	
    	println("Welcome to Hangman");
    	
    	listWord = takeWordFromList();
    	
    	dashWord = convertWordIntoDash(listWord);
    	
    	println(dashWord);
    	
    	canvas.addThreeMainLine();
    	
    	playWhileLivesExists(listWord, dashWord); // give user right to guess numbers while lives exists

    	

	}

    	// println("You have " + livesPerTry + " guessess left.");
    

    
    // in first case, we need to take word from list
    // returns random string from list of Lexicon
    private String takeWordFromList(){
    	
    	int randNumber = randNum.nextInt(1, LEXICON_MAX_WORD_NUMBER);
    	
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
    
    
	// main function is this.
	// its obligations is to play the game while lives exists for user
	
    private void playWhileLivesExists(String listWord, String dashWord){

    	
    	while(gameOn){
    		String ch = readLine("Enter your guess: ");
    		boolean isLetter = checkIfLetter(ch);
    		if(!isLetter){
    			println("Please enter Valid char! ");
    			continue; // if char is valid restart while loop
    		}
    		String guess = ch.toUpperCase(); // converts user input letter into uppercase
    		
    		if(listWord.contains(guess)){
    			char guessCh = guess.charAt(0);
    			dashWord = updateDash(guessCh);
    			
            	if(listWord.equals(dashWord)){
            		println("You Win a Game");
            		gameOn = false;
            	}

    		}else {
    		    livesPerTry--;
    		    println("Incorrect guess! Lives remaining: " + livesPerTry);
    		    canvas.noteIncorrectGuess(guess.charAt(0));
    		    
    	    	if(livesPerTry <= 0){
    	    		canvas.displayWord(listWord, livesPerTry);
    	    		gameOn = false;
    	    		println("You lose a Game");
    	    	}
    		}
    	}
    }
    
    
    
    // takes guess char of user and checks if char exists in listWord.
    // for example: when BUOY is a word and guess is B,
    // it will update like B---;
    
    private String updateDash(char guess) {
    	
        char[] updatedDash = dashWord.toCharArray(); // converts dash into char array.

        for (int i = 0; i < listWord.length(); i++) {
            if (listWord.charAt(i) == guess) {
                updatedDash[i] = guess;
            }
        }
        dashWord = new String(updatedDash);
        canvas.displayWord(dashWord, 1); // we are giving 1 to do not go into if logic in this method. we need to do it from other place in code.
        println("Correct guess! Your world now looks like this: " + dashWord);
        return dashWord;
    }


    
    // checks if user's input char is a letter
    private boolean checkIfLetter(String ch){
    	
    	char guess = ch.charAt(0);
    	
    	// with ASCII standard, defining if guess is letter
    	// for reminding. in this standard for example: 'a' representation
    	// is number 97 in computer's memory.
    	
    	if((65 <= guess && guess <= 90) || (guess >= 97 && guess <=122)){
    		return true;
    	}
    	
    	return false;
    }
    
    // resets the game
    private void tryAgain(){
    	canvas.reset();
    }
}
