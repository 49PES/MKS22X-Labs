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

      int[][] instructions = new int[N][3];
      for(int i = 0; i < N; i++){
        for(int j = 0; j < 3; j++){
          instructions[i][j] = sc.nextInt();
        }
      }
      // while(sc.hasNextLine()){
      //   int[] row = new int[3];
      //   row[0] = sc.nextInt();
      //   row[1] = sc.nextInt();
      //   row[2] = sc.nextInt();
      //   board = append(board, row);
      // }
      // for(int[] row : board){
      //   for(int c : row){
      //     System.out.print(c + " ");
      //   }
      //   System.out.println();
      // }
  }

  public static void megaStomp(int[][] map, int[][] instructions){
    for(int[] instruction : instructions){
      stomp(instruction[0], instruction[1], instruction[2], map);
    }
  }

  public static void stomp(int r, int c, int stomp, int[][] map){
    int max = 0;
    for(int i = r; i < r + 2; i++){
      for(int j = c; j < c + 2; j++){
        if(map[i][j] > max){max = map[i][j]; }
      }
    }

    int minMax = max - stomp;
    for(int i = r; i < r + 2; i++){
      for(int j = c; j < c + 2; j++){
        if(map[i][j] > minMax){map[i][j] = minMax;}
      }
    }
  }
  // public static int[][] append(int[][] board, int[] row){
  //   int[][] updatedBoard = new int[board.length + 1][3];
  //   for(int i = 0; i < board.length; i++){
  //     for(int j = 0; j < board.length; j++){
  //       updatedBoard[i][j] = board[i][j];
  //     }
  //   }
  //
  //   updatedBoard[updatedBoard.length - 1] = row;
  //   return updatedBoard;
  // }

}
