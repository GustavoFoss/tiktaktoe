package core;

import foss.gustavo.tictactoe.Constants;
import foss.gustavo.tictactoe.UI;

public class Game {

  private Board board = new Board();
  private Player[] players = new Player[Constants.SYMBOL_PLAYERS.length];
  private int currentPlayerIndex = -1;

  public void play() throws InvalidMoveException {
    UI.printGameTitle();

    for (int i = 0 ; i < players.length ; i++){
      players[i] = createPlayer(i);
    }

    boolean gameEnded = false;
    Player currentPlayer = nextPlayer();
    Player winner = null;


    while(!gameEnded){

      board.print();
      boolean sequenceFound;

      try {
        sequenceFound = currentPlayer.play();
      }catch (InvalidMoveException e) {
        UI.printText("ERRO: " + e.getMessage());
        continue;
      }
      if (sequenceFound) {
        gameEnded = true;
        winner = currentPlayer;
      }

      else if (board.isFull()) {
        gameEnded = true;
      }

      else{
        currentPlayer = nextPlayer();
      }

    }

    if (winner == null){
      UI.printText("O jogo terminou empatado");
    }

    else {
      UI.printText("O jogador " + winner.getName() + " VENCEU O JOGO!!!");
    }
    System.out.println();
    board.print();
    System.out.println();
    UI.printText("Fim do jogo!!!");
  }

  private Player createPlayer(int index){
    String name = UI.readInput("Jogador " + (index + 1) +" =>");
    char symbol = Constants.SYMBOL_PLAYERS[index];
    Player player = new Player(name , board , symbol);

    UI.printText("O Jogador " + name + " vai usar o símbolo " + symbol);

    return player;
  }
  
  private Player nextPlayer(){
    /**currentPlayerIndex++;
    if (currentPlayerIndex >= players.length){
      currentPlayerIndex = 0;
    }
    return players[currentPlayerIndex];**/
    currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    return players[currentPlayerIndex];
  }
}
