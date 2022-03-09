import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Bronze{
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int R = sc.nextInt();
      int C = sc.nextInt();
      int E = sc.nextInt();
      int N = sc.nextInt();

      // Generate the board
      int[][] map = new int[R][C];
      for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
          sc.nextInt();
        }
      }

      int[][] board = new int[0][3];
      while(sc.hasNextLine()){
        int[] row = new int[3];
        row[0] = sc.nextInt();
        row[1] = sc.nextInt();
        row[2] = sc.nextInt();
        board = append(board, row);
      }
      for(int[] row : board){
        for(int c : row){
          System.out.print(c + " ");
        }
        System.out.println();
      }
  }

  public static int[][] append(int[][] board, int[] row){
    int[][] updatedBoard = new int[board.length + 1][3];
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        updatedBoard[i][j] = board[i][j];
      }
    }

    updatedBoard[updatedBoard.length - 1] = row;
    return updatedBoard;
  }

}
