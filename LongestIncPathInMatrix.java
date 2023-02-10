/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
*/
class Solution {
    int memo[][];
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int maxPath=-1;
        int n=matrix[0].length;
        memo=new int[m+1][n+1];
        for(int i=0;i<m;i++)
        {
            
            for(int j=0;j<n;j++)
                maxPath=Math.max(maxPath, helper(i, j,m,n, matrix));;
        }
        return maxPath;
    }
    int helper(int i, int j,int m, int n, int[][] matrix)
    {
        if(i>=m || j>=n || i<0 || j<0) return 1;
        if(memo[i][j]!=0) return memo[i][j]; 
        int a=1, b=1, c=1, d=1;

        //go left
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]) a=1+helper(i, j-1, m, n, matrix);
        //go right
        if(j+1<n && matrix[i][j+1]>matrix[i][j]) b=1+helper(i, j+1, m, n, matrix);
        //go up
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]) c=1+helper(i-1, j, m, n, matrix);
        //go down
        if(i+1<m && matrix[i+1][j]>matrix[i][j]) d=1+helper(i+1 , j, m, n, matrix);

        return memo[i][j]=Math.max(a,Math.max(b,Math.max(c,d)));
    }
}
