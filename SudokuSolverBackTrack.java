/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
*/
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
}
    boolean helper(char[][] board)
    {
        int n=9;
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {

                if(board[i][j]=='.')
                {
                    for(char k='1'; k<='9';k++)
                    {
                        if(valid(board, i, j, k))
                        {
                            board[i][j]=k;
                            if(helper(board))    return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
                
            }
        }
        return true;
    }
    boolean valid(char[][] board, int x, int y, char k)
    {
        for(int i=0;i<9;i++)
        {
            if(board[x][i]!='.' && board[x][i]==k)  return false;
            if(board[i][y]!='.' && board[i][y]==k)  return false;
            if(board[3*(x/3) + i/3][3*(y/3) + i%3]!='.' && board[3*(x/3) + i/3][3*(y/3) + i%3]==k)  return false;
        }
        return true;
    }
}
