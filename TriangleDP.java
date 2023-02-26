/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 */
METHOD 1:MEMO
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer [][] dp=new Integer[n][n];
        return helper(triangle , 0,0, dp);
    }
    int helper(List<List<Integer>> triangle, int i,int j, Integer [][]dp)
    {
        
        if(i==triangle.size() || j==triangle.get(i).size()) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int n=triangle.get(i).size();
        int path = triangle.get(i).get(j) + Math.min(helper(triangle, i + 1, j, dp ), helper(triangle, i + 1, j+1, dp ));
        return dp[i][j]=path;
    }
}
METHOD 2: DP

class Solution{
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1 ; i>=0; i--)
            for(int j=0; j<=i; j++)
            {
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
            return dp[0][0];
    }
}
