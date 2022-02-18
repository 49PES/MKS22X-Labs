
public class QueenBoard {
  private int[][] board;

  private boolean animated;
  private int delay;

  public void setAnimate(boolean newValue) {
    animated = newValue;
  }

  public void setDelay(int newValue) {
    if (newValue < 0) {
      delay = 0;
    } else {
      delay = newValue;
    }
  }

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  public String toString() {
    String output = "";
    for (int[] row : board) {
      for (int element : row) {
        if (element == -1)
          output += "Q ";
        else
          output += "_ ";
      }
      output += "\n";
    }
    return output;
  }

  private boolean addQueen(int r, int c) {
    // If the position is threatened (denoted when the value is positive), then
    // you can not add a queen at the position
    if (board[r][c] > 0)
      return false;

    modifyBoard(r, c, 1); // Adding a queen = +1 increment

    if (animated) {
      System.out.println(Text.go(1, 1));
      System.out.println(this); // can modify here
      Text.wait(delay);
    }
    return true;
  }

  private void removeQueen(int r, int c) {
    // To prevent weird events from happening, ensure that the code removes a
    // queen only when there is a queen
    if (board[r][c] != -1)
      return;

    if (animated) {
      System.out.println(Text.go(1, 1));
      System.out.println(this);
      Text.wait(delay);
    }

    modifyBoard(r, c, -1); // Removing a queen = -1 increment
  }

  private void modifyBoard(int r, int c, int increment) {
    // Increment: +1 when adding, -1 when subtracting

    board[r][c] += -increment; // Add the queen with a -1 value // Remove the
                               // Queen by adding 1

    int k = 1; // k allows the for-loop to iterate left / right at the same rate
               // as it goes down
    for (int i = r + 1; i < board.length; i++) {
      // DOWN
      board[i][c] += increment;

      // DOWN & LEFT
      if (c - k >= 0) {
        board[i][c - k] += increment;
      }

      // DOWN & RIGHT
      if (c + k < board[0].length) {
        board[i][c + k] += increment;
      }

      k++; // Increment the k to branch out left and right
    }
  }

  // WRAPPER SOLVE
  public boolean solve() {
    return this.solve(0);
  }

  public boolean solve(int row) {
    if (row == board.length) {
      return true;
    } else {
      // Row remaining constant, iterate through the columns
      for (int col = 0; col < board[0].length; col++) {
        if (addQueen(row, col)) {
          // Try adding a queen at the given index
          // If it fully resolves, then the method can return true
          if (solve(row + 1)) {
            return true;
          }

          // Else, remove the queen and proceed to increment column
          removeQueen(row, col);
        }
      }
      return false;
    }
  }

  // WRAPPER COUNT SOLUTIONS
  public int countSolutions() {
    return this.countSolutions(0);
  }

  public int countSolutions(int row) {
    if (row == board.length) {
      return 1;
    } // BASE CASE
    // If the board has been completed (when row == board.length => all the rows
    // have been filled succesfully), return 1 for 1 valid configuration

    int numSolutions = 0;
    for (int column = 0; column < board.length; column++) {
      if (addQueen(row, column)) {
        numSolutions += countSolutions(row + 1);
        removeQueen(row, column);
      }
    }
    return numSolutions;
  }

  public static void main(String[] args) {
    int SIZE = 8;
    if (args.length > 0) {
      SIZE = Integer.parseInt(args[0]);
    }
    QueenBoard b = new QueenBoard(SIZE);
    if (args.length > 1) {
      b.setAnimate(true);
      b.setDelay(Integer.parseInt(args[1]));
    }
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.HIDE_CURSOR);
    System.out.println(Text.go(1, 1));
    b.solve();
    System.out.println(Text.RESET);
    System.out.println(Text.go(1, 1));
    System.out.println(b);

    QueenBoard foo = new QueenBoard(SIZE);
    System.out.println(foo.countSolutions());
  }
}
