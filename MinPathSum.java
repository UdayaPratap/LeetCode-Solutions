/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
  */
class Solution {
    int minSum=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int memo[][]=new int[grid.length][grid[0].length];
        for(int t[]: memo) Arrays.fill(t, -1);
        return helper(grid, 0, 0, memo);
    }
    int helper(int[][] grid, int i, int j, int[][] memo){
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        if(i==grid.length || j==grid[0].length) return Integer.MAX_VALUE;
        if(memo[i][j]!=-1) return memo[i][j];
        int down=helper(grid, i+1, j, memo);
        int right=helper(grid, i, j+1, memo);
        return memo[i][j]=grid[i][j]+Math.min(down,right);
    }
}
