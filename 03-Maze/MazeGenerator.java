public class MazeGenerator{
  public static void generate(char[][] maze, int startrow, int startcol){
    maze[startrow][startcol] = 'S';
    generateR(maze, 0, 0);
  }

  public static void generateR(char[][] maze, int row, int col){
    // // Recursive base case - when the maze has been fully carved
    // if(row == maze.length - 2 && col == maze[0].length - 1) { System.out.println(toString(maze)); return;}
    // if(row == 0) {
    //   generateR(maze, row + 1, col); // If on the top edge, recurse down - top edge
    // }
    // if(col == 0) {
    //   generateR(maze, row, col + 1); // Don't carve the left edge
    // }
    // if(col == maze[0].length - 1){
    //   generateR(maze, row + 1, 0); // Loop around when at the end of the row
    // }
    //
    // if(maze[row][col] == '#' &&  wallNeighborCounter(maze, row, col) > 2){
    //   // if the given index is a wall and there is fewer than 2 neighbors, then the wall is safe to carve
    //   maze[row][col] = ' ';
    // }
    // generateR(maze, row, col + 1);

    if(valid(maze, row, col) ){
      maze[row][col] == ' ';
      generateR(maze, row - 1, col);


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

  // public static int[][] positionsGenerator(char[][] array){
  //   int[][] positions = new int[array.length * array[0].length][2];
  //   int index = 0;
  //   for(int i = 0; i < array.length; i++){
  //     for(int j = 0; j < array[0].length; j++){
  //       positions[index] = new int[] {i, j};
  //       System.out.println(positions[index][0] + ", " + positions[index][1]);
  //       index++;
  //     }
  //   }
  //
  //   return positions;
  //
  // }
  public static void main(String[] args){
    // char[][] array = new char[4][4];
    // positionsGenerator(array);
  }
}
