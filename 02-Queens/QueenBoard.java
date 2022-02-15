
public class QueenBoard{
	private int[][] board;

	public QueenBoard(int size){
		board = new int[size][size];
	}

	public String toString(){
		String output = "";
		for(int[] row : board){
			for(int i = 0; i < row.length; i++){
				if(i == 0){
					if(row[i] == -1) { output += "Q";}
					else {output += "_";}
				}
				else{
					if(row[i] == -1) { output += " Q";}
					else {output += " _";}
				}
			}
			output += "\n";
		}
		return output;
	}

	public String toStringNumber(){
		// Just for print statement inspections for issues
		String output = "";
		for(int[] row : board){
			for(int i = 0; i < row.length; i++){
				if(i == 0){
					output += "" + row[i];
				}
				else{
					output += " " + row[i];
				}
			}
			output += "\n";
		}
		return output;
	}

	private boolean addQueen(int r, int c){
		// If the position is threatened (denoted when the value is positive), then you can not add a queen at the position
		if(board[r][c] > 0){return false;}

		modifyBoard(r, c, 1); // Adding a queen = +1 increment
		return true;
	}

	private void removeQueen(int r, int c){
			modifyBoard(r, c, -1); // Removing a queen = -1 increment
	}

	private void modifyBoard(int r, int c, int increment){
		// Increment: +1 when adding, -1 when subtracting

		board[r][c] += -increment; // Add the queen with a -1 value // Remove the Queen by adding 1

		int k = 1;
		for(int i = r + 1; i < board.length; i++){
			// DOWN
			board[i][c] += increment;

			// DOWN & LEFT
			if(c - k >= 0){
				board[i][c - k] += increment; // Increment the diagonal going DOWN and LEFT
			}

			// DOWN & RIGHT
			if(c + k < board[0].length){
				board[i][c + k] += increment;
			}

			k++; // Increment the k to branch out left and right
		}

	}

	boolean solve(int row){
		if(row == board.length) {return true;}
		else{
			// Row remaining constant, iterate through the columns
			for(int col = 0; col < board[0].length; col++){
				if(addQueen(row, col) ){
					// Try adding a queen at the given index
					// If it fully resolves, then the method can return true
					if(solve(row + 1)){
						return true;
					}

					// Else, remove the queen and proceed to increment column
					removeQueen(row, col);
				}
			}
			return false;
		}
	}

	public static void main(String[] args){
		QueenBoard foo = new QueenBoard(8);

		// PRELIMINARY CHECK UP
		// System.out.println("Default board:");
		// System.out.println(foo.toString() ); // Verifies whether the construction worked
		//
		// System.out.println("Adding Queen at (4, 4)");
		// foo.addQueen(4, 4);
		// System.out.println(foo.toString() );
		// System.out.println(foo.toStringNumber() ); // Verify that adding a queen works
		//
		// System.out.println("Trying to add Queen at (5, 5)");
		// foo.addQueen(5, 5);
		// System.out.println(foo.toString() ); // Verify that adding does *not* work when the position is threatened
		//
		// System.out.println("Add Queen at (1, 2)");
		// foo.addQueen(1, 2);
		// System.out.println(foo.toString() );
		// System.out.println(foo.toStringNumber() ); // Verify that the values aggregate properly
		//
		// System.out.println("Remove Queen at (4, 4)");
		// foo.removeQueen(4, 4);
		// System.out.println(foo.toString() );
		// System.out.println(foo.toStringNumber() ); // Verify that removing works
		//
		// foo.removeQueen(1, 2);

		foo.solve(0);
		System.out.println(foo.toString() );
	}
}
