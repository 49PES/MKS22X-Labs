import java.util.Arrays;
import java.util.ArrayList;
public class MazeGenerator{

  public static void generate(char[][] board, int startrow, int startcol){
    generateR(board, startrow, startcol);
    board[startrow][startcol] = 'S';

    ArrayList<int[]> availableEnds = emptySpaces(board);
    int x = 0, y = 0, maxMoves = 0;
    char[][] copyBoard;
    for(int[] choice : availableEnds){
      copyBoard = copyBoard(board);
      copyBoard[choice[0]][choice[1]] = 'E';
      int numMoves = new Maze( copyBoard ).solve( );
      if(numMoves > maxMoves){
        maxMoves = numMoves;
        x = choice[0];
        y = choice[1];
      }
    }
    board[x][y] = 'E';
  }

  public static void generateR(char[][] board, int row, int col){
    if(canCarve(board, row, col)){
      board[row][col] = ' ';
      ArrayList<int[]> directions = directions(board, row, col);
      while(directions.size() > 0){
        int index = (int) (Math.random() * directions.size());

        int[] direction = directions.get(index);
        directions.remove(index);

        generateR(board, row + direction[0], col + direction[1]);
      }

    }
  }


  public static ArrayList<int[]> emptySpaces(char[][] board){
    ArrayList<int[]> spaces = new ArrayList<int[]>();
    for(int i = 1; i < board.length - 2; i++){
      for(int j = 1; j < board[0].length - 2; j++){
        if(board[i][j] == ' '){
          spaces.add(new int[] {i, j});
        }
      }
    }
    return spaces;
  }

  public static char[][] copyBoard(char[][] board){
    char[][] copy = new char[board.length][board[0].length];
    for(int i = 0; i < copy.length; i++){
      for(int j = 0; j < copy[0].length; j++){
        copy[i][j] = board[i][j];
      }
    }
    return copy;
  }
  //can carve: not on border, not a space, fewer than 2 neighboring spaces
  public static boolean canCarve(char[][] board, int row, int col){
    // 4 neighbors == not on border
    // == '#' : it is a wall
    // fewer than 2 neighboring spaces
    return (neighborCounter(board, row, col) == 4 && board[row][col] == '#' && spaceNeighborCounter(board, row, col) < 2 );
  }

  public static int neighborCounter(char[][] board, int row, int col){
    int counter = 0;

    if(row != 0){counter++;}

    if(row != board.length - 1){counter++;}

    if(col != 0){counter++;}

    if(col != board[0].length - 1){counter++;}

    return counter;
  }

  public static int spaceNeighborCounter(char[][] board, int row, int col){
    int counter = 0;

    if(row != 0 && board[row - 1][col] == ' '){counter++;}

    if(row != board.length - 1 && board[row + 1][col] == ' '){counter++;}

    if(col != 0 && board[row][col - 1] == ' '){counter++;}

    if(col != board[0].length - 1 && board[row][col + 1] == ' '){counter++;}

    return counter;
  }

  public static ArrayList<int[]> directions(char[][] board, int row, int col){
    ArrayList<int[]> directions = new ArrayList<int[]>();
    if(row != 0 && canCarve(board, row - 1, col)){
      directions.add(new int[] {-1, 0});
    }

    if(row != board.length - 1 && canCarve(board, row + 1, col)){
      directions.add(new int[] {1, 0});
    }

    if(col != 0 && canCarve(board, row, col - 1)){
      directions.add(new int[] {0, -1});
    }

    if(col != board[0].length - 1 && canCarve(board, row, col + 1)){
      directions.add(new int[] {0, 1});
    }
    return directions;

  }

  public static String toString(char[][] maze){
    String output = "";
    for(char[] row : maze){
      output += new String(row) + "\n";
    }
    return output;
  }

  public static void main(String[] args){
    // char[][] board = new char[10][20];
    // for(char[] row : board){
    //   for(int j = 0; j < row.length; j++){
    //     row[j] = '#';
    //   }
    // }
    // System.out.println(toString(board));
    // generate(board, 3, 1);
    // System.out.println(toString(board));
  }
}
