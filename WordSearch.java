/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length, m=board[0].length;
        if(n==1 && m==1 && word.length()==1 && board[0][0]==word.charAt(0))  return true;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]==word.charAt(0)){
                    boolean visited[][]=new boolean[n][m];
                    boolean ans=helper(board,word, i, j, visited);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
    boolean helper(char[][] board, String word, int i, int j, boolean[][] visited)
    {
        if(word.length()==0) return true;
        
        int n=board.length, m=board[0].length;
        if(!visited[i][j] && board[i][j]==word.charAt(0)){
            visited[i][j]=true;
            boolean left=false, right=false, up=false, down=false;
            left=j-1>=0 ? helper(board,word.substring(1), i, j-1, visited) : false;
            if(left) return true;
            right=j+1<m ? helper(board,word.substring(1), i, j+1, visited) : false;
            if(right) return true;
            up=i-1>=0 ? helper(board,word.substring(1), i-1, j, visited) : false;
            if(up) return true;
            down=i+1<n ? helper(board,word.substring(1), i+1, j, visited) : false;
            if(down) return true;
            visited[i][j]=false;
        }
        return false;
    }
}
