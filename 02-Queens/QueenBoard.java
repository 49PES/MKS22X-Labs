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
			modifyBoard(r, c, 1); // Removing a queen = -1 increment
	}

	private void modifyBoard(int r, int c, int increment){
		// Increment: +1 when adding, -1 when subtracting

		board[r][c] += -increment; // Add the queen with a -1 value // Remove the Queen by adding 1
		for(int i = r + 1; i < board.length; i++){
			board[i][c] += increment; // Increment the values below the added queen by +1
		}

		for(int j = r + 1; j < board.length; j++){
			for(int k = c - 1; k >= 0; k--){
				board[j][k] += increment; // Increment the diagonal going to the bottom-left of the added Queen by +1 // Subtract 1 if Queen is removed
				// Assumption is that this is a n x n square - modify second for-loop to k < board[0].length otherwise
			}
		}

		for(int j = r + 1; j < board.length; j++){
			for(int k = c + 1; k < board.length; k++){
				board[j][k] += increment; // Increment the diagonal going to the bottom-right of the added Queen by +1 // Subtract 1 if Queen is removed
				// Assumption is that this is a n x n square - modify second for-loop to k < board[0].length otherwise
			}
		}

	}

	public static void main(String[] args){

	}
}
