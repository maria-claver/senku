package com.claver.games.senku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Senku {

  private Map<Integer, Map<Integer, Cell>> grid;
  private Cell pegToMove;
  private Integer pegs;

  public Senku() {
    createGrid();
    initGrid();
  }

  public Map<Integer, Map<Integer, Cell>> getGrid() {
    return grid;
  }
  public Cell getPegToMove() {
    return pegToMove;
  }
  public Integer getPegs() {
    return pegs;
  }

  public void createGrid() {
    /* Grid looks like this:
       0 1 2 3 4 5 6 7 8
     0 . . . x x x . . .
     1 . . . x x x . . .
     2 . . . x x x . . .
     3 x x x x x x x x x
     4 x x x x o x x x x
     5 x x x x x x x x x
     6 . . . x x x . . .
     7 . . . x x x . . .
     8 . . . x x x . . .
     */
    grid = new HashMap<>();
    for (int row=0; row < 9; row++) {
      int minColumn = 0;
      int maxColumn = 9;
      if (row < 3 || row > 5) {
        minColumn = 3;
        maxColumn = 6;
      }
      Map<Integer, Cell> cells = new HashMap<>();
      for (int column = minColumn; column < maxColumn; column++) {
        cells.put(column, new Cell(row, column));
      }
      grid.put(row, cells);
    }
  }

  public void initGrid() {
    pegs = 0;
    for (Map.Entry<Integer, Map<Integer, Cell>> row : grid.entrySet()) {
      for (Integer column : row.getValue().keySet()) {
        Cell cell = row.getValue().get(column);
        if (row.getKey() != 4 || column != 4) {
          cell.setPeg(true);
          pegs++;
        }
      }
    }
  }


  public void selectPegToMove(Position position) {
    selectPegToMove(position.row, position.column);
  }
  public void selectPegToMove(Integer row, Integer column) {
    if (!isValidCell(row, column)) {
      throw new IllegalArgumentException("The selected cell is not in the game grid!");
    }
    pegToMove = grid.get(row).get(column);
    if (!pegToMove.hasPeg()) {
      pegToMove = null;
      throw new IllegalStateException("There is no peg there!");
    }
    if (!pegHasPossibleMovements()) {
      pegToMove = null;
      throw new IllegalStateException("This peg can't move anywhere!");
    }
  }

  private boolean pegHasPossibleMovements() {
    if (pegToMove.hasPeg()) {
      List<Position> possibleDestinations = new ArrayList<>();
      possibleDestinations.add(new Position(pegToMove.getRow()-2, pegToMove.getColumn()));
      possibleDestinations.add(new Position(pegToMove.getRow()+2, pegToMove.getColumn()));
      possibleDestinations.add(new Position(pegToMove.getRow(), pegToMove.getColumn()-2));
      possibleDestinations.add(new Position(pegToMove.getRow(), pegToMove.getColumn()+2));
      for (Position position : possibleDestinations) {
        if (isValidCell(position) && !cellHasPeg(position) && isValidJump(position)) {
          return true;
        }
      }
    }
    return false;
  }

  public void movePegTo(Position position) {
    movePegTo(position.row, position.column);
  }
  public void movePegTo(Integer row, Integer column) {
    if (pegToMove == null) {
      throw new IllegalStateException("There is no selected peg to move!");
    }
    if (!isValidCell(row, column)) {
      throw new IllegalArgumentException("That is not a valid cell!");
    }
    if (!isValidJump(row, column)) {
      throw new IllegalStateException("The peg must jump over an adjacent peg!");
    }

    Cell destinationCell = grid.get(row).get(column);
    if (destinationCell.hasPeg()) {
      throw new IllegalStateException("There is already a peg there!");
    }

    pegToMove.setPeg(false);
    grid.get((pegToMove.getRow() + row)/2).get((pegToMove.getColumn() + column)/2).setPeg(false);
    pegs--;
    destinationCell.setPeg(true);
    pegToMove = null;
  }

  private boolean cellHasPeg(Position position) {
    return grid.get(position.row).get(position.column).hasPeg();
  }

  private boolean isValidCell(Position position) {
    return isValidCell(position.row, position.column);
  }
  private boolean isValidCell(Integer row, Integer column) {
    return grid.containsKey(row) && grid.get(row).containsKey(column);
  }

  private boolean isValidJump(Position position) {
    return isValidJump(position.row, position.column);
  }
  private boolean isValidJump(Integer rowTo, Integer columnTo) {
    Integer rowFrom = pegToMove.getRow();
    Integer columnFrom = pegToMove.getColumn();

    return (Math.abs(rowTo - rowFrom) == 0 || Math.abs(rowTo - rowFrom) == 2)
        && (Math.abs(columnTo - columnFrom) == 0 || Math.abs(columnTo - columnFrom) == 2)
        && (Math.abs(rowTo - rowFrom) + Math.abs(columnTo - columnFrom) == 2)
        && grid.get((rowTo + rowFrom)/2).get((columnTo + columnFrom)/2).hasPeg();
  }

  public boolean isFinished() {
    return pegs == 0;
  }

  public boolean noMoreMovements() {
    for (Map<Integer, Cell> row : grid.values()) {
      for (Cell cell : row.values()) {
        pegToMove = cell;
        if (pegHasPossibleMovements()) {
          pegToMove = null;
          return false;
        }
      }
    }
    pegToMove = null;
    return true;
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(" ");
    for (int column = 0; column < 9; column++) {
      result.append(" ").append(column).append(" ");
    }
    result.append("\n");
    for (int row = 0; row < 9; row++) {
      result.append(row);
      for (int column = 0; column < 9; column++) {
        if (isValidCell(row, column)) {
          Cell cell = grid.get(row).get(column);
          if (cell.hasPeg()) {
            result.append(" o ");
          } else {
            result.append(" . ");
          }
        } else {
          result.append("   ");
        }
      }
      result.append("\n");
    }

    return result.toString();
  }

}
