import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class ReadFile {
  // public static int[] getValuesFromFile(String filename) throws FileNotFoundException{
  //   File text = new File(filename);
  //   //code here to read file into array
  // }

  public static void getValuesFromFile() throws FileNotFoundException{
    try {
      File file = new File("Maze1.txt");
      Scanner sc = new Scanner(file);
      String fullStr = "";
      int numRows = 0, numColumns = 0;
      char[][] maze = new char[0][0];
      while (sc.hasNextLine()){
        String str = sc.nextLine();
        fullStr += str + "\n";
        numColumns = str.length();
        numRows++;
      }
      for(int i = 0; i < numRows; i++){
        char[] ch = (fullStr.substring(i, i + (numColumns - 1))).toCharArray();
        // System.out.println(Arrays.toString(ch) );
        maze = append(maze, ch);
      }

      for(char[] row : maze){
        System.out.println(new String(row) );
      }
      // char[] ch = str.toCharArray();
      // System.out.println(Arrays.toString(ch));
      // System.out.println(fullStr);
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

  public static void main(String args[]) throws FileNotFoundException{
    // int[]nums = new int[0];
    // try{
    //   nums = getValuesFromFile("Numbers.csv");
    // }catch(FileNotFoundException e){
    //   //error handling code
    // }
    getValuesFromFile();

  }
}
