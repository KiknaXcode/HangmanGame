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

	
	// adds three main lines
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
	
	private GLabel letterLabel = new GLabel("", 0, 0);

	
	public void displayWord(String word) {
		
		remove(letterLabel);
		
	    int x = getWidth() / 2 - BEAM_LENGTH;

	    letterLabel = new GLabel(word, x + 50, getHeight() - 50);
	    letterLabel.setFont("Arial-Bold-20"); // Adjust font and size based on your design
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

	
	

	
	
	private void drawHead() {
	    int x = getWidth() / 2 - HEAD_RADIUS;
	    int y = getHeight() / 2 + ROPE_LENGTH;

	    // Draw the head as a filled oval
	    GOval head = new GOval(x, y, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
	    head.setFilled(true);
	    add(head);
	}

	
	
	private void drawBody() {
	    int x = getWidth() / 2;
	    int y = getHeight() / 2 + ROPE_LENGTH;

	    GLine bodyLine = new GLine(x, y, x, y + BODY_LENGTH);
	    add(bodyLine);
	}
	
	private void drawLeftHand() {
	    int xBody = getWidth() / 2;
	    int yBody = getHeight() / 2 + ROPE_LENGTH + BODY_LENGTH;

	    // Coordinates for the left hand
	    int xLeftHand = xBody - ARM_OFFSET_FROM_HEAD;
	    int yLeftHand = yBody + UPPER_ARM_LENGTH;

	    // Draw the left hand
	    GLine leftHandLine = new GLine(xBody, yBody, xLeftHand, yLeftHand);
	    add(leftHandLine);
	}
	
	
	private void drawRightHand() {
	    int xBody = getWidth() / 2;
	    int yBody = getHeight() / 2 + ROPE_LENGTH + BODY_LENGTH;

	    // Coordinates for the right hand
	    int xRightHand = xBody + ARM_OFFSET_FROM_HEAD;
	    int yRightHand = yBody + UPPER_ARM_LENGTH;

	    // Draw the right hand
	    GLine rightHandLine = new GLine(xBody, yBody, xRightHand, yRightHand);
	    add(rightHandLine);
	}
	


	private void drawLeftFoot() {
	    int xBody = getWidth() / 2;
	    int yBody = getHeight() / 2 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH;

	    // Coordinates for the left foot
	    int xLeftFoot = xBody - HIP_WIDTH / 2;
	    int yLeftFoot = yBody + FOOT_LENGTH;

	    // Draw the left foot
	    GRect leftFootRect = new GRect(xLeftFoot, yLeftFoot, HIP_WIDTH, FOOT_LENGTH);
	    add(leftFootRect);
	}

	private void drawRightFoot() {
	    int xBody = getWidth() / 2;
	    int yBody = getHeight() / 2 + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH;

	    // Coordinates for the right foot
	    int xRightFoot = xBody + HIP_WIDTH / 2 - FOOT_LENGTH;
	    int yRightFoot = yBody + FOOT_LENGTH;

	    // Draw the right foot
	    GRect rightFootRect = new GRect(xRightFoot, yRightFoot, HIP_WIDTH, FOOT_LENGTH);
	    add(rightFootRect);
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
