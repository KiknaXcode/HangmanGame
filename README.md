# Hangman Game Project

## Overview
The **Hangman Game Project** is a simple implementation of the classic Hangman game using Java. The project consists of three classes: **Hangman**, **HangmanCanvas**, and **HangmanLexicon**. The game allows users to guess words and features a graphical representation of the hangman.

## Classes

### **Hangman**
The main class that initializes the game, manages user input, and controls the game flow.

### **HangmanCanvas**
Responsible for rendering the hangman graphics based on the user's incorrect guesses.

### **HangmanLexicon**
Handles the lexicon of words used in the game. In Part III of the assignment, it was modified to read words from a file.

## Getting Started
1. Clone the repository to your local machine.
2. Open the project in your Java development environment (e.g., Eclipse, IntelliJ).
3. Run the **Hangman** class to start the game.

## Gameplay
- The game starts by displaying a word as a series of dashes.
- The player guesses letters to reveal the hidden word.
- Incorrect guesses result in parts of a hangman being drawn.
- The game ends when the player guesses the word or runs out of lives.

## Project Files
- **Hangman.java**: The main class that orchestrates the game.
- **HangmanCanvas.java**: Handles graphical representation.
- **HangmanLexicon.java**: Manages the list of words for the game.

## Customization
- You can customize the list of words by modifying the **HangmanLexicon.txt** file.

## Acknowledgments
This **Hangman Game Project** was created as part of a programming assignment. It demonstrates the use of Java, file I/O, and basic graphical rendering.

Feel free to adapt this README to fit the specifics of your project. Add any additional sections or details that may be relevant to users or contributors.
