/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int memo[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int t[]: memo) Arrays.fill(t, -1);
        return helper(obstacleGrid, 0, 0, memo);
    }
    int helper(int[][] matrix, int i, int j, int[][] memo){
        if(i==matrix.length || j==matrix[0].length) return 0;
        if(matrix[i][j]==1) return 0;
        if(i==matrix.length-1 && j==matrix[0].length-1) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        return memo[i][j]=helper(matrix, i+1, j, memo)+helper(matrix, i, j+1, memo);
    }
}
