// Maxwell Lin

public class Hangman {
  private String answer; // answer of game
  private String knowns; // current knowns of answer
  
  private int attempts; // default is 6
  
  // Initializes this.answer with answer and knowns with length of answer. You start with 6 attempts
  public Hangman(String answer) {
    this.answer = answer;
    knowns = repeatChar('*', answer.length());

    attempts = 6;
  }
  
  // Getter methods
  public String getAnswer() {
    return answer;
  }
  public String getKnowns() {
    return knowns;
  }
  public int getAttempts() {
    return attempts;
  }
  
  // Returns true if game has ended, false otherwise
  public boolean gameEnded() {
    return attempts <= 0 || knowns.equals(answer);
  }
  
  // Helper method for Hangman constructor Hangman(String) that returns a String that repeats a letter length times
  private String repeatChar(char letter, int length) {
    String string = new String();

    for (int i=0; i<length; i++) {
      string += letter;
    }

    return string;
  }
  
  // Main logic of Hangman. Checks whether the answer contains the user input and changes attempts and knowns as necessary
  public void checkAnswer(char input) {
    if (answer.indexOf(input) != -1 && knowns.indexOf(input) == -1) {
      for (int i=0; i<answer.length(); i++) {
        if (answer.charAt(i) == input) {
          knowns = replaceChar(knowns, i, input);
        }
      }
    } else {
      attempts--;
    }
  }
  
  // Helper method for checkAnswer()
  // Returns a newString that replaces the character at index of a string with newChar
  private String replaceChar(String string, int index, char newChar) {
    String former = string.substring(0, index);
    String latter = string.substring(index+1, string.length());
    String newString = former + newChar + latter;

    return newString;
  }
}