package foss.gustavo.tictactoe;

import core.Game;
import core.InvalidMoveException;

import java.io.IOException;


public class Main {
  public static void main(String[] args) throws InvalidMoveException, IOException {
   Game g =  new Game();

   g.play();
  }
}
