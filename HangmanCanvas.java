/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import acm.util.RandomGenerator;

public class HangmanCanvas extends GCanvas {
	
	RandomGenerator rg = RandomGenerator.getInstance();

/** Resets the display so that only the scaffold appears */
	public void reset() {
	    removeAll();
	    addThreeMainLine();
	}

	private void addThreeMainLine() {
		
	    int x = getWidth() / 2 - BEAM_LENGTH;
	    int y = getHeight() / 2 - SCAFFOLD_HEIGHT / 2;
	    
	    // Draw scaffold
	    GLine scaffoldLine = new GLine(x, y, x, y + SCAFFOLD_HEIGHT);
	    add(scaffoldLine);
	    
	    // Draw beam
	    GLine beamLine = new GLine(x, y, x + BEAM_LENGTH, y);
	    add(beamLine);
	    
	    // Draw rope
	    GLine ropeLine = new GLine(x + BEAM_LENGTH, y, x + BEAM_LENGTH, y + ROPE_LENGTH);
	    add(ropeLine);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far;
 */
	public void displayWord(String word) {
		
	    int x = getWidth() / 2 - BEAM_LENGTH;
	    int y = getHeight() / 2 + 50; // Adjust the y-coordinate based on your design

	    for (int i = 0; i < word.length(); i++) {
	        char ch = word.charAt(i);
	        if (ch != '-') {
	            GLabel letterLabel = new GLabel("" + ch, x + i * 20, y);
	            letterLabel.setFont("Arial-Bold-20"); // Adjust font and size based on your design
	            add(letterLabel);
	        }
	    }
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		drawHead();
	}
	
	
	
	private void addThreeLine(){
		
		
	}
	
	
	private void drawHead(){
		GOval oval = new GOval(40, 40, 40, 40);
		oval.setFilled(true);
		oval.setFillColor(rg.nextColor());
		add(oval);
	}
	
	

	

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
