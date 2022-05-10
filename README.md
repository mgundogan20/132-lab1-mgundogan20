# Collaboration Rules
This lab  is an indivual work. Everyone should submit their own work. You can use any material from the course, or any other resource on Java programming language. You can discuss lecture related topics, the problem at the concept level with other students, but not the solution. You can reuse (copy-paste) code only from the lecture notes, textbook, or code given in the lab, but not from others (internet sources, other students etc.)

# Honor Code - by submitting lab work you accept:
- This code is my own work. 
- I did not consult to any program written other students. 
- I did not search for the solution of the problem in the internet.
- I did not copy-paste code written by others.


# LAB 1
You are given a Java project template for Lab1 assignment. The project has a main class (and main method). It  is the driver code which calls several class methods that you are asked to implement (Lab problems). Some problems will be given before the lab so that you can start working on it. Some problems will be given during the lab.

## Problem 1 - Implementing a simple game

### Game

This is game where two players alternately take cards from a deck  of cards. In each move, a player chooses how many cards to take.  In his/her turn, the player must take at least one but not more than half of the cards (a valid value).  Then the next player takes turn.  The player who takes the final card loses.

You are asked to write a program in which the computer plays against a human  opponent. Your program, at the beginning, should ask

- the number of cards in the deck, the human player enters an integer
- computer playing mode - the user enters 0 for stupid, 1 for smart mode, If invalid int value entered,asks again.  
- asks who starts first, the user enters 0 for human, 1 for computer. If invalid int value entered,asks again. 

At each turn, your program prints the number of remaining cards. If it is human's turn, the program asks the number of cards to be removed, and it checks if it is a valid integer value, keeps asking until the human player enters a valid input.

The computer plays in two modes:

- stupid: removes a random number (valid)  of cards
- smart: removes enough cards to make the remaining number of cards 2^n-1, that is 3,7, 15, 31, 63 etc. with a valid move, except if the number of cards is currently one less than a power of 2. In that case a random number (valid) of cards are removed.

### Classes/Methods

Your implementation are constrained with the following:

- has two classes Game and Computer (see how the main method invokes Game class methods)
- we will check for  style: indentation, variable naming conventions (camel case) etc.
- in addition to the public methods, Game class should have some helper methods (private). This is due to top-down refinement. You don't want to put everyting in one big method. We expect at least one helper method.
- Computer class represents computer player
- Demonstrate while and do-while: use while iteration construct in reading computer mode, a do-while construct  in the part getting the player turn. (repeatedly asking until a valid int vlaue entered).
- Computer has a booelan  instance variable to remember if it is playing stupid or smart mode.
- have setter and getter method for the instance variables
- Computer class has the following public method:
```
// plays one turn.
// paramter:      numberOfCards - is the current number of cards in the deck
// returns:        the number of cards to be removed
int play(int numberOfCards)
```

### A sample output

```
Enter number of cards:100
Enter 0 if the computer plays in stupid mode, 1 for smart mode:1
Computer is playing in smart mode
Enter 0 if the human stars,  1 if computer starts:0
0
There are 100 cards left
Your turn.  How many you want to remove:50
There are 50 cards left
Computer removed 19 cards
There are 31 cards left
Your turn.  How many you want to remove:15
There are 16 cards left
Computer removed 9 cards
There are 7 cards left
Your turn.  How many you want to remove:1
There are 6 cards left
Computer removed 3 cards
There are 3 cards left
Your turn.  How many you want to remove:1
There are 2 cards left
Computer removed 1 cards
Computer Wins

```

