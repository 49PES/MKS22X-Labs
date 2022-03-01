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
    try {
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

      // for(char[] row : maze){
      //   System.out.println(new String(row) );
      // }
      // String stringMaze = "";
      // for(char[] row : maze){
      //   stringMaze += new String(row) + "\n";
      // }
      //
      // System.out.println(stringMaze + "BOO" );

    }
    catch (Exception e) {
      throw new FileNotFoundException("File not found");
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
    // return "WRITE THIS METHOD";
    String output = "";
    for(char[] row : maze){
      for(char element : row){
        output += element;
      }
      output += "\n";
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
      System.out.println(this);
      wait(50);
    }

    //COMPLETE SOLVE
    return -1; //so it compiles
  }

  public static void main(String[] args) throws FileNotFoundException {
    Maze maze1 = new Maze("Maze1.txt");
    System.out.println(maze1.toString() );
  }
}
