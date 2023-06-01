/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int[][] dp=new int[n][m];
        int max=0;
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j>=0; j--){
                if(matrix[i][j]=='1'){
                    if((i+1<n && dp[i+1][j]!=0) && (j+1<m && dp[i][j+1]!=0) && dp[i+1][j+1]!=0){
                        dp[i][j]= Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]))+1;
                    }
                    else{
                        dp[i][j]=1;
                    }
                    max=Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
        
    }
}
