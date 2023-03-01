/*
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
*/
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // int[][] grid=new int[m][n];
        dp=new Long[m+1][n+1][maxMove+1];
        long ans=helper(m,n, maxMove, startRow, startColumn);
        return (int)ans%MOD;
    }
    Long dp[][][];
    int MOD = (int)1e9 + 7;
    long helper(int n, int m, int moves, int i, int j)
    {
        // int n=grid.length, m=grid[0].length;
        if(i>=n || j>=m || i<0 || j<0) return 1;
        // if(grid[i][j]==1 || moves==0) return 0;
        if(moves==0) return 0;
        if(dp[i][j][moves]!=null) return dp[i][j][moves];
        return dp[i][j][moves]=(helper(n,m, moves-1, i+1, j)%MOD+helper(n,m, moves-1, i-1, j)%MOD+helper(n,m, moves-1, i, j+1)%MOD+helper(n,m, moves-1, i, j-1)%MOD)%MOD;
    }
    // public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    //     // int[][] grid=new int[m][n];
    //     long[][][]dp= new long[m][n][maxMove+1];
    //     int mod = (int)1e9 + 7;
    //     for(int move=1; move<=maxMove; move++){
    //         for(int i=0;i<m;i++){
    //             for(int j=0;j<n;j++){
    //                     long up = (i-1>=0)? dp[i-1][j][move-1]%mod:1;
    //                     long down = (i+1<m)? dp[i+1][j][move-1]%mod:1;
    //                     long lft = (j-1>=0)? dp[i][j-1][move-1]%mod:1;
    //                     long rt = (j+1<n)? dp[i][j+1][move-1]%mod :1;
                    
    //                     dp[i][j][move]= (up+ down+ lft+ rt)%mod;
    //             }
    //         }
    //     }
    //     return (int)dp[startRow][startColumn][maxMove]%mod;
    // }
}
