/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minCost=Integer.MAX_VALUE;
        Integer dp[][]=new Integer[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix[0].length; i++)
        {
            minCost=Math.min(minCost, helper(matrix, 0, i, dp));
        }
        return minCost;
    }
    int helper(int[][] matrix, int row, int col, Integer[][] dp){
        if(col<0 || col==matrix[0].length) return Integer.MAX_VALUE;
        if(row==matrix.length-1) return matrix[row][col];
        if(dp[row][col]!=null) return dp[row][col];

        int a=helper(matrix, row+1, col, dp);
        int b=helper(matrix, row+1, col-1, dp);
        int c=helper(matrix, row+1, col+1, dp);

        return dp[row][col]=matrix[row][col]+Math.min(a, Math.min(b, c));
    }
}
