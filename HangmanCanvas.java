/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import acm.util.RandomGenerator;

public class HangmanCanvas extends GCanvas {
	
	RandomGenerator rg = RandomGenerator.getInstance();
	
    private boolean headDrawn = false;
    private boolean bodyDrawn = false;
    private boolean leftHandDrawn = false;
    private boolean rightHandDrawn = false;
    private boolean leftFootDrawn = false;
    private boolean rightFootDrawn = false;

/** Resets the display so that only the three main lines appear */
	public void reset() {
	    removeAll();
	    addThreeMainLine();
	}


/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far;
 */
	
	private GLabel letterLabel = new GLabel("", 0, 0);

	
	public void displayWord(String word, int livesLeft) {
		
		remove(letterLabel);
	    int x = getWidth() / 2 - BEAM_LENGTH;
	    letterLabel = new GLabel(word, x + 50, getHeight() - 50);
	    letterLabel.setFont("Arial-Bold-20"); 
	    add(letterLabel);
	    
	    if(livesLeft <=0){
	    	displayFinalWord(word);
	    }
	    
	    

	}
	
	private void displayFinalWord(String word){
	    int x = getWidth() / 2 - BEAM_LENGTH;
	    letterLabel = new GLabel(word, x + 50, getHeight() - 25);
	    letterLabel.setFont("Arial-15"); 
	    add(letterLabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
	    if (!headDrawn) {
	        drawHead();
	        headDrawn = true;
	    } else if (!bodyDrawn) {
	        drawBody();
	        bodyDrawn = true;
	    } else if (!leftHandDrawn) {
	        drawLeftHand();
	        leftHandDrawn = true;
	    } else if (!rightHandDrawn) {
	        drawRightHand();
	        rightHandDrawn = true;
	    } else if (!leftFootDrawn) {
	        drawLeftFoot();
	        leftFootDrawn = true;
	    } else if (!rightFootDrawn) {
	        drawRightFoot();
	        rightFootDrawn = true;
	    }
	}
	
	
    int x = ARM_OFFSET_FROM_HEAD;
    int y = getHeight() / 2 + ARM_OFFSET_FROM_HEAD / 4;
    
    
	// adds three main lines
	public void addThreeMainLine() {
		
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
	
	
	
    private GOval head;
	
    
 // Draw the head
	private void drawHead() {
	    x = x + BEAM_LENGTH - HEAD_RADIUS;
	    y = y + ROPE_LENGTH;

	    head = new GOval(x, y, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);

	    add(head);
	}

	
	// draw body
	private void drawBody() {
		
	    x = x + HEAD_RADIUS;
	    y = y + 2 * HEAD_RADIUS;

	    GLine bodyLine = new GLine(x, y, x, y + BODY_LENGTH);
	    add(bodyLine);
	}
	
	
	// Draw the left hand
	private void drawLeftHand() {

		y = y + BODY_LENGTH/2;
	    GLine leftHandLineStraight = new GLine(x, y, x - UPPER_ARM_LENGTH, y);
	    GLine leftHandLineDown = new GLine(x - UPPER_ARM_LENGTH, y, x - UPPER_ARM_LENGTH, y + LOWER_ARM_LENGTH);
	    add(leftHandLineStraight);
	    add(leftHandLineDown);
	}
	
	
	
	// Draw the left hand
	private void drawRightHand() {
	    GLine leftHandLineStraight = new GLine(x, y, x + UPPER_ARM_LENGTH, y);
	    GLine leftHandLineDown = new GLine(x + UPPER_ARM_LENGTH, y, x + UPPER_ARM_LENGTH, y + LOWER_ARM_LENGTH);
	    add(leftHandLineStraight);
	    add(leftHandLineDown);
	}
	


	
	private void drawLeftFoot() {
		
		y = y + BODY_LENGTH/2;
		
	    // Draw the left hand
	    GLine leftFootLineStraight = new GLine(x, y, x - HIP_WIDTH, y);
	    GLine leftFootLineDown = new GLine(x - HIP_WIDTH, y, x - HIP_WIDTH, y + LEG_LENGTH);
	    GLine leftFootFinalpart = new GLine(x - HIP_WIDTH, y + LEG_LENGTH, x - HIP_WIDTH - FOOT_LENGTH, y + LEG_LENGTH);
	    
	    add(leftFootLineStraight);
	    add(leftFootLineDown);
	    add(leftFootFinalpart);
	}

	private void drawRightFoot() {
	    // Draw the left hand
	    GLine rightFootLineStraight = new GLine(x, y, x + HIP_WIDTH, y);
	    GLine rightFootLineDown = new GLine(x + HIP_WIDTH, y, x + HIP_WIDTH, y + LEG_LENGTH);
	    GLine rightFootFinalpart = new GLine(x + HIP_WIDTH, y + LEG_LENGTH, x + HIP_WIDTH + FOOT_LENGTH, y + LEG_LENGTH);
	    
	    add(rightFootLineStraight);
	    add(rightFootLineDown);
	    add(rightFootFinalpart);
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
