package com.claver.games.senku;

public class Cell {
  private final Position position;
  private boolean peg;

  public Cell(Integer row, Integer column) {
    this.position = new Position(row, column);
  }

  public Integer getRow() {
    return position.row;
  }
  public Integer getColumn() {
    return position.column;
  }

  public String toString() {
    return position.toString();
  }

  public void setPeg(boolean peg) {
    this.peg = peg;
  }

  public boolean hasPeg() {
    return peg;
  }

}
