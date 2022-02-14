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

	public static void main(String[] args){

	}
}
