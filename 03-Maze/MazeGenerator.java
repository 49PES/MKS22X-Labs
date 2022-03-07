public class MazeGenerator{
  public static void generate(char[][] maze, int startrow, int startcol){
    maze[startrow][startcol] = 'S';
    generateR(maze, 1, 1);
  }

  public static void generateR(char[][] maze, int row, int col){
    if(valid(maze, row, col) ){
      maze[row][col] = ' ';
      if(valid(maze, row - 1, col)) {System.out.println("North is valid!"); generateR(maze, row - 1, col);}
      if(valid(maze, row, col - 1)) {System.out.println("West is valid!");  generateR(maze, row , col - 1);}
      if(valid(maze, row + 1, col)) {System.out.println("South is valid!");  generateR(maze, row + 1, col);}
      if(valid(maze, row, col + 1)) {System.out.println("East is valid!");  generateR(maze, row, col + 1);}
    }

  }

  public static boolean valid(char[][] array, int row, int col){
    // A position is safe to carve if
    // - it is a wall
    // - it is not on a border (must have 4 neighbors)
    // - "if before carving there are fewer than 2 ways to step into the square" (more than 2 wall neighbors)
    return (array[row][col] == '#' && neighborCounter(array, row, col) == 4 && wallNeighborCounter(array, row, col) > 2);
  }

  public static int neighborCounter(char[][] array, int row, int col){
    int counter = 0;

    if(row != 0){counter++;}
    if(row != array.length - 1){counter++;}
    if(col != 0){counter++;}
    if(col != array[0].length - 1){counter++;}

    return counter;
  }

  public static int wallNeighborCounter(char[][] array, int row, int col){
    int counter = 0;

    if(row != 0 && array[row - 1][col] == '#')  {counter++;} // NORTH
    if(row != array.length && array[row + 1][col] == '#')  {counter++;} // SOUTH
    if(col != 0 && array[row][col - 1] == '#')  {counter++;} // EAST
    if(col != array[0].length - 1  && array[row][col - 1] == '#')  {counter++;} // WEST

    return counter;
  }

  public static String toString(char[][] maze){
    String output = "";
    for(char[] row : maze){
      output += new String(row) + "\n";
    }
    return output;
  }


  public static void main(String[] args){
    char[][] maze = new char[5][10];
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[0].length; j++){
        maze[i][j] = '#';
      }
    }
    generate(maze, 3, 1);
    System.out.println(toString(maze) );
  }
}
