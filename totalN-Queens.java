/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 */
 class Solution {
    public int totalNQueens(int n) {
        
        char[][] board=new char[n][n];
        for (char c[] : board) Arrays.fill(c, '.');
        return helper(n, 0, board);
    }
    int helper(int n,int row, char[][] board)
    {
        if(row==n){
            return 1;
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(safe(board, row, i)){
                board[row][i]='Q';
                count+=helper(n, row+1, board);
                board[row][i]='.';
            }
        }
        return count;
    }
    boolean safe(char[][] board,int row,int col)
	{
		int n=board.length;
		for(int i=0;i<n;i++)
		{
			if(board[row][i]=='Q') return false;
            if(board[i][col]=='Q') return false;
        }
		
		for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--)
  		  if(board[i][j] =='Q') return false;

  	    for(int i=row-1,j=col+1;i>=0 && j<n ; i--,j++)
    	  if(board[i][j] == 'Q') return false;

		return true;
	}
}
