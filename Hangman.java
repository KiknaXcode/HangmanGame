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
	
	boolean gameOn = false;

    public void run() {
    	
    	
    	// in first case, we need to take word from list
    	int randNumber = randNum.nextInt(0, 10);
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	println(randNumber);
    	
    	
		
    	while(gameOn){
    		println("The word now looks like this: ");
    		
    	}
	}

}
