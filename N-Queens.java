/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        char[][] board=new char[n][n];
        for (char c[] : board) Arrays.fill(c, '.');
        helper(n, 0, board, curr, ans);
        return ans;
    }
    void helper(int n,int row, char[][] board, List<String> curr, List<List<String>> ans)
    {
        if(row==n){
            for(int i=0;i<n;i++)
            {
                String s="";
                for(int j=0;j<n;j++)
                    s+=""+board[i][j];
                curr.add(s);
                
            }
            ans.add(new ArrayList<String>(curr));
            curr.clear();
            return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(safe(board, row, i)){
                board[row][i]='Q';
                helper(n, row+1, board, curr, ans);
                board[row][i]='.';
            }
        }
        return;
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
