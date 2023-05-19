/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++){
                if(board[i][j]!="." && !validRowCol(board, i, j) || !validBox(board, i, j)) return false;
            }
        return true;
    }
    boolean validRowCol(char[][] board, int i, int j)
    {
        int n=board.length;
        for(int id=0; id<n; id++)
        {
            if(id!=j && board[i][id]==board[i][j]) return false;
            if(id!=i && board[id][j]==board[i][j]) return false;
        }
        return true;
    }
    boolean validBox(char[][] board, int i, int j)
    {
        
    }
}
