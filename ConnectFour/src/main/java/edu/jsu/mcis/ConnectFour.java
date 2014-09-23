package edu.jsu.mcis;

public class ConnectFour {
    public enum Token { RED, BLACK, EMPTY }
    public enum Result { NONE, RED_WIN, BLACK_WIN, TIE }
    public static final int COLUMNS = 7;
    private final int ROWS = 6;
    private Token[][] board;
    private boolean redTurn;
    
    public ConnectFour() {
        board = new Token[ROWS][COLUMNS];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Token.EMPTY;
            }
        }
        redTurn = true;
    }
    
    public Token getTopOfColumn(int col) {
		char insert = 'E';
		for( int row = 5; row > -1; row --){
			if (board[row][col] == Token.RED)
				insert = 'R';
			else if (board[row][col] == Token.BLACK)
				insert = 'B';
		}
		
		if (insert == 'R')
			return Token.RED;
		else if (insert == 'B')
			return Token.BLACK;
		else 
			return Token.EMPTY;
		
    }
    
    public int getHeightOfColumn(int col) {
		int height = 0;
		for( int row  = 0; row < 6 ; row ++){
			if(board[row][col] == Token.BLACK)
				height ++;
			else if (board[row][col] == Token.RED)
				height ++;
		}
        return height;
    }
    
    public boolean dropTokenInColumn(int col) {
		boolean dropToken = false;
		for(int row = 5; row > -1; row --){
			if(board[row][col] == Token.EMPTY){
				dropToken = true;
				if(redTurn)
					board[row][col] = Token.RED;
				else
					board[row][col] = Token.BLACK;
				redTurn = !redTurn;
				break;
			}
			else 
				dropToken = false;
		}
		
		return dropToken;
		
    }
    
    public Result getResult() {
		String winner = "";
		for( int i  = 0; i < 7; i ++){
			if(doesRedWinVerticallyInColumn(i))
				winner = "Red";
		}
		if (winner == "Red")
			return Result.RED_WIN;
		else 
			return Result.TIE;
 
    }
    
    
    // Here are a couple of private methods to give you
    // an idea of a more clever way to determine winners.
    private boolean doesRedWinVerticallyInColumn(int col) {
        String columnString = makeStringFromColumn(col);
        return (columnString.indexOf("RRRR") >= 0);
    }
    
    private String makeStringFromColumn(int col) {
        String s = "";
        for(int row = 0; row < ROWS; row++) {
            if(board[row][col] == Token.RED) s += "R";
            else if(board[row][col] == Token.BLACK) s += "B";
            else s += " "; 
        }
        return s;
    }
}












