package com.claver.games.senku;

public class Position {
  public final Integer row;
  public final Integer column;

  public Position(Integer row, Integer column) {
    this.row = row;
    this.column = column;
  }

  public String toString() {
    return "[" + row + ", " + column + "]";
  }

}
