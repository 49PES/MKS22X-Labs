import java.util.*;
import java.io.*;
public class Maze{
  private char[][] maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException
  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)
  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */


  public Maze(String filename) throws FileNotFoundException{
    File file = new File(filename);
    Scanner sc = new Scanner(file);
    String fullStr = "";
    int numRows = 0, numColumns = 0;
    maze = new char[0][0];
    while (sc.hasNextLine()){
      String str = sc.nextLine();
      char[] ch = str.toCharArray();
      maze = append(maze, ch);
    }
  }


  public static char[][] append(char[][] maze, char[] newRow){
    char[][] newMaze = new char[maze.length + 1][newRow.length];
    for(int i = 0; i < maze.length; i++){
      newMaze[i] = maze[i];
    }
    newMaze[maze.length] = newRow;
    return newMaze;
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString(){
    return toString(this.maze);
  }

  public static String toString(char[][] array){
    String output = "";
    for(char[] row : array){
      output += new String(row) + "\n";
    }
    return output;
  }
  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  // public int solve(){
  //   //only clear the terminal if you are running animation
  //   if(animate){
  //     clearTerminal();
  //   }
  //   //start solving at the location of the s.
  //   return solve(startRow,startCol);
  //
  // }

  /*
  Recursive Solve function:
  A solved maze has a path marked with '@' from S to E.
  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.
  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      gotoTop();
      System.out.println(this.toString() );
      wait(50);
    }

    //COMPLETE SOLVE
    if(maze[row][col] == 'E') return 0;
    if(!valid(row, col)) return -1;

    maze[row][col] = '@';
    if(animate){
      gotoTop();
      System.out.println(this.toString() );
      wait(50);
    }
    int s = solve(row  + 1, col);
    if(s > -1){
      return s + 1;
    }

    int n = solve(row - 1, col);
    if(n > -1){
      return n + 1;
    }

    int w = solve(row, col - 1);
    if(w > -1){
      return w + 1;
    }

    int e = solve(row, col + 1);
    if(e > -1){
      return e + 1;
    }


    maze[row][col] = '.';
    if(animate){
      gotoTop();
      System.out.println(this.toString() );
      wait(50);
    }
    return -1; //so it compiles
  }

  public int solve(){
    int x = 0, y = 0;
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[0].length; j++){
        if(maze[i][j] == 'S'){
          x =  i; y = j;
        }
      }
    }
    return this.solve(x, y);
  }

  public static void generator(char[][] array){
    for(int i = 0; i < array[0].length; i++){
      array[0][i] = '#';
      array[array.length - 1][i] = '#';
    }
    for(int j = 0; j < array.length; j++){
      array[j][0] = '#';
      array[j][array[0].length - 1] = '#';
    }
    for(int i = 1; i < array.length - 1; i++){
      for(int j = 1; j < array[0].length - 1; j++){
        array[i][j] = ' ';
      }
    }
    System.out.println(toString(array));
  }

  public static void generator(char[][] array, int row, int col){
    if(array[row][col] != '#'){
      // Not a wall
      return;
    }

  }

  public boolean valid(int row, int column){
    return (maze[row][column] != '#' && maze[row][column] != '@' && maze[row][column] != '.');
  }
  public static void main(String[] args) throws FileNotFoundException {
    Maze maze1 = new Maze("Maze1.txt");
    // System.out.println(maze1.toString() );
    // maze1.setAnimate(true);
    // // maze1.solve(7, 1);
    // // System.out.println(maze1.toString());
    // System.out.println(maze1.solve(7, 1));
    char[][] array = new char[5][15];
    generator(array);

    for(char[] row : array){
      for(char element : row){
        System.out.print(element);
      }
      System.out.println();
    }
  }
}
