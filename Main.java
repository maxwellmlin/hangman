// Maxwell Lin

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    char input;

    Hangman game = new Hangman("hello");
    
    // Main game loop; will continue until either player wins or loses
    while (!game.gameEnded()) {
        System.out.println("Attempts left: " + game.getAttempts());
        System.out.println("Knowns: " + game.getKnowns());

        System.out.print("Guess a character: ");
        input = scanner.next().toLowerCase().charAt(0); // Reads the next character and lowers it (if given a String, will only use the first character of the String)

        game.checkAnswer(input);

        System.out.println();
    }

    if (game.getAttempts() == 0) System.out.println("You lost!");
    else System.out.println("You won!");

    scanner.close();
  }
}