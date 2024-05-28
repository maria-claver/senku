package com.claver.games.senku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SenkuMain {
  // Senku is the name of the game known as "Peg Solitaire", a solitaire game played with
  // wooden pegs on a cross-shaped grid, where you have to jump one over the others
  // and end with just one peg, at the center of the grid if possible for bonus points.

  public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {
    System.out.println("*********************");
    System.out.println("* Welcome to Senku! *");
    System.out.println("*********************\n");

    try {
      play();
    } catch (IOException e) {
      System.out.println("Ooopsie! Error reading from terminal! :S\n" + e.getMessage());
    }
  }

  private static void play() throws IOException {
    System.out.println("Let's play!");
    Senku senku = new Senku();
    System.out.println(senku);

    boolean finished = false;
    while (!finished) {
      selectPeg(senku);
      movePeg(senku);

      System.out.println(senku);
      if (senku.isFinished()) {
        System.out.println("YAYYY!!! YOU WON! :D\n");
        finished = true;
      } else if (senku.noMoreMovements()) {
        System.out.println("Ooooh... No more movements... Sorry, you lost :(\n");
        finished = true;
      }
    }

    System.out.println("Wanna play again (Y) or exit (any other key) ?");
    if (readBooleanFromTerminal("Y")) {
      System.out.println("ok, let's play again then");
      play();
    } else {
      System.out.println("oh, sad to see you go");
      quit();
    }
  }

  private static void selectPeg(Senku senku) throws IOException {
    boolean isPegSelected = false;
    while (!isPegSelected) {
      System.out.println("> Enter the row of the peg to move:");
      Integer rowFrom = readIntegerFromTerminal(0, 9);
      System.out.println("> Enter the column of the peg to move:");
      Integer columnFrom = readIntegerFromTerminal(0, 9);
      try {
        senku.selectPegToMove(new Position(rowFrom, columnFrom));
        isPegSelected = true;
      } catch (IllegalStateException | IllegalArgumentException e) {
        System.out.println("Can't select peg on the given position! " + e.getMessage() + " Please, try again:");
      }
    }
  }

  private static void movePeg(Senku senku) throws IOException {
    boolean isPegMoved = false;
    while (!isPegMoved) {
      System.out.println("> Enter the row of the new position to move the peg to:");
      Integer rowTo = readIntegerFromTerminal(0, 9);
      System.out.println("> Enter the column of the new position to move the peg to:");
      Integer columnTo = readIntegerFromTerminal(0, 9);
      try {
        senku.movePegTo(new Position(rowTo, columnTo));
        isPegMoved = true;
      } catch (IllegalStateException | IllegalArgumentException e) {
        System.out.println("Can't move the peg there! " + e.getMessage());
      }
    }
  }

  private static Integer readIntegerFromTerminal(Integer minValue, Integer maxValue) throws IOException {
    Integer value = null;
    while (value == null) {
      try {
        String stringValue = reader.readLine();
        value = Integer.valueOf(stringValue);
        if (value < minValue) {
          System.out.println("Too small! Please, try again: ");
          value = null;
        } else if (value > maxValue) {
          System.out.println("Too big! Please, try again: ");
          value = null;
        }
      } catch (NumberFormatException e) {
        System.out.println("Sorry, didn't catch that, could you please try again?");
      }
    }
    return value;
  }

  private static boolean readBooleanFromTerminal(String key) throws IOException {
    try {
      String stringValue = reader.readLine();
      return stringValue.equalsIgnoreCase(key);
    } catch (IOException e) {
      System.out.println("ERROR reading from terminal: " + e.getMessage());
      throw e;
    }
  }

  private static void quit() {
    System.out.println("Thank you for playing with me! Bye!");
    System.out.println("             _ o . o _/¨           ");
    System.exit(0);
  }

}
