import java.io.*;
import java.util.Scanner;
public class Silver{
  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(solve("ctravel.in") );
  }

  public static long solve(String filename) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(filename));
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int time = sc.nextInt();

    int[][] map = new int[rows][cols];

    for(int i = 0; i < rows; i++){
      String str = sc.next();
      for(int j = 0; j < cols; j++){
        if(str.substring(j, j+ 1).equals(".")){
          map[i][j] = 0;
        }
        else if( str.substring(j, j+ 1).equals("*")){
          map[i][j] = -1;
        }
      }
    }

    int initialRow = sc.nextInt() - 1;
    int initialCol = sc.nextInt() - 1;
    map[initialRow][initialCol] = 1;
    map = travel(map, 0, time);
    int finalRow = sc.nextInt() - 1;
    int finalCol = sc.nextInt() - 1;
    return map[finalRow][finalCol] ;
  }

  public static int[][] travel(int[][] map, int time, int finalTime){
    if(time == finalTime){return map;}
    int[][] copyMap = new int[map.length][map[0].length];
    for(int i = 0; i < map.length; i++){
      for(int j = 0; j < map[0].length; j++){
        if(map[i][j] == -1){
          copyMap[i][j] = -1;
        }
        else{
          copyMap[i][j] = neighborSum(map, i, j);
        }
      }
    }
    map = copyMap;

    return travel(map, time + 1, finalTime);
  }

  public static int neighborSum(int[][] map, int row, int col){
    int sum = 0;
    if(isValid(map, row - 1, col) && map[row - 1][col] != -1) sum += map[row - 1][col];
    if(isValid(map, row + 1, col) && map[row + 1][col] != -1) sum += map[row + 1][col];
    if(isValid(map, row, col -1) && map[row][col - 1] != -1) sum += map[row][col - 1];
    if(isValid(map, row, col + 1) && map[row][col + 1] != -1) sum += map[row][col + 1];
    return sum;
  }

  public static boolean isValid(int[][] map, int row, int col){
    return(row >= 0 && row < map.length && col >= 0 && col < map[0].length);
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
}
