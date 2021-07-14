package core;

import foss.gustavo.tictactoe.Constants;
import foss.gustavo.tictactoe.UI;

public class Board {
  private char[][] matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

  public Board(){
    clear();
  }

  public void clear(){
    for(int i = 0; i < matrix.length; i++){
      for (int j = 0; j < matrix[i].length; j++){
        matrix[i][j] = ' ';
      }
    }
  }

  public void print(){
    for (int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++ ){
        UI.printTextWithNoNewLine(String.valueOf(matrix[i][j]));
        if (j < matrix[i].length - 1) {
          UI.printTextWithNoNewLine(" | ");
        }
      }
      UI.printNewLine();

      if (i < matrix.length - 1){
        UI.printText("---------");
      }
    }
  }

  public boolean isFull(){
    for(int i = 0; i < matrix.length; i++){
      for (int j = 0; j < matrix[i].length; j++){
        if (matrix[i][j] == ' '){
          return false;
        }
      }
    }
    return true;
  }

  public boolean play(Player player, Move move){
    int i = move.getI();
    int j = move.getJ();

    matrix[i][j] = player.getSymbol();

    return checkCols(player) || checkRows(player) || checkDiagonal1(player) || checkDiagonal2(player);
  }

  private boolean checkRows(Player player){
    for (int i = 0; i < Constants.BOARD_SIZE; i++){
      if (checkRow(i, player)){
        return true;
      }
    }
    return false;
  }

  private boolean checkRow(int i, Player player){
    char symbol = player.getSymbol();
    for (int j = 0; j < Constants.BOARD_SIZE; j++){
      if (matrix[i][j] != symbol){
        return false;
      }
    }
    return true;
  }

  private boolean checkCol(int j, Player player){
    char symbol = player.getSymbol();
    for (int i = 0; i < Constants.BOARD_SIZE; i++){
      if (matrix[i][j] != symbol){
        return false;
      }
    }
    return true;
  }

  private boolean checkCols(Player player){
    for (int j = 0; j < Constants.BOARD_SIZE; j++){
      if (checkCol(j, player)){
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonal1(Player player){
    char symbol = player.getSymbol();

    for (int i = 0 ; i < Constants.BOARD_SIZE ; i++){
      if (matrix[i][i] != symbol){
        return false;
      }
    }

    return true;
  }

  private boolean checkDiagonal2(Player player){

    char symbol = player.getSymbol();

    int lastLine = Constants.BOARD_SIZE - 1;

    for (int i = lastLine,j = 0 ; i >= 0; i-- , j++){
      if (matrix[i][j] != symbol){
        return false;
      }
    }

    return true;
  }
}
