package core;

import foss.gustavo.tictactoe.Constants;
import foss.gustavo.tictactoe.UI;

public class Game {

  private Board board = new Board();
  private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];

  public void play(){
    UI.printGameTitle();

    board.print();
  }
}
