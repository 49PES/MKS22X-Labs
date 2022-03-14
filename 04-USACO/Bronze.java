import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Bronze{
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(solve("makelake.in") );
  }

  public static void stomp(int[][] map, int[][] instructions){
    for(int[] instruction : instructions){
      int row = instruction[0] - 1;
      int col = instruction[1] - 1;
      int stomp = instruction[2];
      int max = 0;

      for(int i = row; i < row + 3; i++){
        for(int j = col; j < col + 3; j++){
          if (map[i][j] > max) {max = map[i][j];}
        }
      }

      for(int i = row; i < row + 3; i++){
        for(int j = col; j < col + 3; j++){
          if(map[i][j] > max - stomp) map[i][j] = max - stomp;
        }
      }
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

  public static String toString(int[][] map){
    String output = "";
    for(int[] row : map){
      for(int c : row){
        output += c + " ";
      }
      output += "\n";
    }
    return output;
  }

  public static long solve(String filename) throws FileNotFoundException{
    Scanner sc = new Scanner(new File(filename));
    int R = sc.nextInt();
    int C = sc.nextInt();
    int E = sc.nextInt();
    int N = sc.nextInt();

    // Generate the board
    int[][] map = new int[R][C];
    for(int i = 0; i < R; i++){
      for(int j = 0; j < C; j++){
        map[i][j] =  sc.nextInt();
      }
    }

    int[][] instructions = new int[N][3];
    for(int i = 0; i < N; i++){
      for(int j = 0; j < 3; j++){
        instructions[i][j] = sc.nextInt();
      }
    }


    stomp(map, instructions);

    int sum = 0;
    for(int i = 0; i < R; i++){
      for(int j = 0; j < C; j++){
        map[i][j] = E - map[i][j];
        if(map[i][j] > 0){sum += map[i][j];}
      }
    }
    return (sum * 72 * 72);
  }

}
