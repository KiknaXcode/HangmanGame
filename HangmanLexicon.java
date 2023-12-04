/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import acm.program.ConsoleProgram;
import acm.util.*;

public class HangmanLexicon extends ConsoleProgram{
	
	
    private ArrayList<String> wordsList;

    // This is the HangmanLexicon constructor
    public HangmanLexicon() {
        wordsList = new ArrayList<>();
        initializeWordList();
    }
    
    
    // Reads lines from the file and stores them in the ArrayList
    private void initializeWordList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("HangmanLexicon.txt"));
            String line = reader.readLine();
            while (line != null) {
                wordsList.add(line);
            }
            println(wordsList);
            reader.close();
        } catch (IOException e) {
            println("Error reading the file: " + e.getMessage());
        }
    }

    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return wordsList.size();
    }

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return wordsList.get(index);
	}
}
