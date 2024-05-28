package com.claver.games.senku;

import org.junit.Test;

public class TestSenku {

  @Test
  public void testCreateGrid() {
    Senku senku = new Senku();
    assert senku.getGrid().size() == 9;
    assert senku.getGrid().containsKey(0);
    assert senku.getGrid().get(0).size() == 3;
    assert senku.getGrid().get(0).containsKey(3);
    assert senku.getGrid().get(0).get(3).hasPeg();
    assert senku.getGrid().get(0).containsKey(4);
    assert senku.getGrid().get(0).get(4).hasPeg();
    assert senku.getGrid().get(0).containsKey(5);
    assert senku.getGrid().get(0).get(5).hasPeg();

    assert senku.getGrid().containsKey(1);
    assert senku.getGrid().get(1).size() == 3;
    assert senku.getGrid().get(1).containsKey(3);
    assert senku.getGrid().get(1).get(3).hasPeg();
    assert senku.getGrid().get(1).containsKey(4);
    assert senku.getGrid().get(1).get(4).hasPeg();
    assert senku.getGrid().get(1).containsKey(5);
    assert senku.getGrid().get(1).get(5).hasPeg();

    assert senku.getGrid().containsKey(2);
    assert senku.getGrid().get(2).size() == 3;
    assert senku.getGrid().get(2).containsKey(3);
    assert senku.getGrid().get(2).get(3).hasPeg();
    assert senku.getGrid().get(2).containsKey(4);
    assert senku.getGrid().get(2).get(4).hasPeg();
    assert senku.getGrid().get(2).containsKey(5);
    assert senku.getGrid().get(2).get(5).hasPeg();

    assert senku.getGrid().containsKey(3);
    assert senku.getGrid().get(3).size() == 9;
    assert senku.getGrid().get(3).containsKey(0);
    assert senku.getGrid().get(3).get(0).hasPeg();
    assert senku.getGrid().get(3).containsKey(1);
    assert senku.getGrid().get(3).get(1).hasPeg();
    assert senku.getGrid().get(3).containsKey(2);
    assert senku.getGrid().get(3).get(2).hasPeg();
    assert senku.getGrid().get(3).containsKey(3);
    assert senku.getGrid().get(3).get(3).hasPeg();
    assert senku.getGrid().get(3).containsKey(4);
    assert senku.getGrid().get(3).get(4).hasPeg();
    assert senku.getGrid().get(3).containsKey(5);
    assert senku.getGrid().get(3).get(5).hasPeg();
    assert senku.getGrid().get(3).containsKey(6);
    assert senku.getGrid().get(3).get(6).hasPeg();
    assert senku.getGrid().get(3).containsKey(7);
    assert senku.getGrid().get(3).get(7).hasPeg();
    assert senku.getGrid().get(3).containsKey(8);
    assert senku.getGrid().get(3).get(8).hasPeg();

    assert senku.getGrid().containsKey(4);
    assert senku.getGrid().get(4).size() == 9;
    assert senku.getGrid().get(4).containsKey(0);
    assert senku.getGrid().get(4).get(0).hasPeg();
    assert senku.getGrid().get(4).containsKey(1);
    assert senku.getGrid().get(4).get(1).hasPeg();
    assert senku.getGrid().get(4).containsKey(2);
    assert senku.getGrid().get(4).get(2).hasPeg();
    assert senku.getGrid().get(4).containsKey(3);
    assert senku.getGrid().get(4).get(3).hasPeg();
    assert senku.getGrid().get(4).containsKey(4);
    assert !senku.getGrid().get(4).get(4).hasPeg();
    assert senku.getGrid().get(4).containsKey(5);
    assert senku.getGrid().get(4).get(5).hasPeg();
    assert senku.getGrid().get(4).containsKey(6);
    assert senku.getGrid().get(4).get(6).hasPeg();
    assert senku.getGrid().get(4).containsKey(7);
    assert senku.getGrid().get(4).get(7).hasPeg();
    assert senku.getGrid().get(4).containsKey(8);
    assert senku.getGrid().get(4).get(8).hasPeg();

    assert senku.getGrid().containsKey(5);
    assert senku.getGrid().get(5).size() == 9;
    assert senku.getGrid().get(5).containsKey(0);
    assert senku.getGrid().get(5).get(0).hasPeg();
    assert senku.getGrid().get(5).containsKey(1);
    assert senku.getGrid().get(5).get(1).hasPeg();
    assert senku.getGrid().get(5).containsKey(2);
    assert senku.getGrid().get(5).get(2).hasPeg();
    assert senku.getGrid().get(5).containsKey(3);
    assert senku.getGrid().get(5).get(3).hasPeg();
    assert senku.getGrid().get(5).containsKey(4);
    assert senku.getGrid().get(5).get(4).hasPeg();
    assert senku.getGrid().get(5).containsKey(5);
    assert senku.getGrid().get(5).get(5).hasPeg();
    assert senku.getGrid().get(5).containsKey(6);
    assert senku.getGrid().get(5).get(6).hasPeg();
    assert senku.getGrid().get(5).containsKey(7);
    assert senku.getGrid().get(5).get(7).hasPeg();
    assert senku.getGrid().get(5).containsKey(8);
    assert senku.getGrid().get(5).get(8).hasPeg();

    assert senku.getGrid().containsKey(6);
    assert senku.getGrid().get(6).size() == 3;
    assert senku.getGrid().get(6).containsKey(3);
    assert senku.getGrid().get(6).get(3).hasPeg();
    assert senku.getGrid().get(6).containsKey(4);
    assert senku.getGrid().get(6).get(4).hasPeg();
    assert senku.getGrid().get(6).containsKey(5);
    assert senku.getGrid().get(6).get(5).hasPeg();

    assert senku.getGrid().containsKey(7);
    assert senku.getGrid().get(7).size() == 3;
    assert senku.getGrid().get(7).containsKey(3);
    assert senku.getGrid().get(7).get(3).hasPeg();
    assert senku.getGrid().get(7).containsKey(4);
    assert senku.getGrid().get(7).get(4).hasPeg();
    assert senku.getGrid().get(7).containsKey(5);
    assert senku.getGrid().get(7).get(5).hasPeg();

    assert senku.getGrid().containsKey(8);
    assert senku.getGrid().get(8).size() == 3;
    assert senku.getGrid().get(8).containsKey(3);
    assert senku.getGrid().get(8).get(3).hasPeg();
    assert senku.getGrid().get(8).containsKey(4);
    assert senku.getGrid().get(8).get(4).hasPeg();
    assert senku.getGrid().get(8).containsKey(5);
    assert senku.getGrid().get(8).get(5).hasPeg();

    assert senku.getPegs() == 44;
  }

  @Test
  public void testPrintGrid() {
    Senku senku = new Senku();
    assert senku.toString().equals(
          "  0  1  2  3  4  5  6  7  8 \n"
        + "0          o  o  o          \n"
        + "1          o  o  o          \n"
        + "2          o  o  o          \n"
        + "3 o  o  o  o  o  o  o  o  o \n"
        + "4 o  o  o  o  .  o  o  o  o \n"
        + "5 o  o  o  o  o  o  o  o  o \n"
        + "6          o  o  o          \n"
        + "7          o  o  o          \n"
        + "8          o  o  o          \n");

  }

  @Test
  public void testSelectValidPegToMove() {
    Senku senku = new Senku();
    assert senku.getPegToMove() == null;
    senku.selectPegToMove(3, 3);
    assert senku.getPegToMove() != null;
    assert senku.getPegToMove().hasPeg();
    assert senku.getPegToMove().getRow().equals(3);
    assert senku.getPegToMove().getColumn().equals(3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSelectPegToMoveFromInvalidCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSelectPegToMoveFromOutOfBoundsCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(-1,11);
  }

  @Test(expected = IllegalStateException.class)
  public void testSelectPegToMoveFromEmptyCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(4,4);
  }

  @Test(expected = IllegalStateException.class)
  public void testSelectPegToMoveWithNoMovements() {
    Senku senku = new Senku();
    senku.selectPegToMove(5, 1);
  }

  @Test
  public void testMovePegOk() {
    Senku senku = new Senku();
    senku.selectPegToMove(2,4);
    senku.movePegTo(4, 4);
    assert senku.getPegToMove() == null;
    assert !senku.getGrid().get(2).get(4).hasPeg();
    assert !senku.getGrid().get(3).get(4).hasPeg();
    assert senku.getGrid().get(4).get(4).hasPeg();

    assert senku.getPegs() == 43;
  }

  @Test(expected = IllegalStateException.class)
  public void testMovePegWithoutSelectedPeg() {
    Senku senku = new Senku();
    senku.movePegTo(4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMovePegToInvalidCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(2, 4);
    senku.movePegTo(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMovePegToOutOfBoundsCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(2, 4);
    senku.movePegTo(-1, 10);
  }

  @Test(expected = IllegalStateException.class)
  public void testMovePegNotJumpingOverAdjacentPeg() {
    Senku senku = new Senku();
    senku.selectPegToMove(1, 4);
    senku.movePegTo(4, 4);
  }

  @Test(expected = IllegalStateException.class)
  public void testMovePegToNonEmptyCell() {
    Senku senku = new Senku();
    senku.selectPegToMove(1, 4);
    senku.movePegTo(3, 4);
  }

}
