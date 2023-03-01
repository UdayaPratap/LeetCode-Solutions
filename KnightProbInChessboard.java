/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.
*/
class Solution {
    int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    Double dp[][][];
    public double knightProbability(int n, int k, int row, int column) {
        dp=new Double[n][n][k+1];
        return helper(n, k, row ,column);
    }
    
    double helper(int n , int k , int i, int j)
    {
        if(i<0 || j<0 || i>=n || j>=n) return 0;
        if(k==0) return 1;
        if(dp[i][j][k]!=null) return dp[i][j][k];
        double prob=0;
        for(int d=0;d<8;d++) prob+= 0.125 * helper(n, k-1, i+dir[d][0], j+dir[d][1]);
        return dp[i][j][k]=prob;
    }
}
