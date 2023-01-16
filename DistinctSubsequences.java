/*
Given two strings s and t, return the number of distinct 
subsequences
 of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 */
class Solution {
    
    public int numDistinct(String s, String t){
        int[][] dp=new int [s.length()+1][t.length()+1];
         Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        return helper(s, t, dp);
    }
    public int helper(String s, String t, int[][] dp) {
       if(t.length()==0)
        return 1;
        if(s.length()==0)
        return 0;

        if(dp[s.length()][t.length()]!=-1)
             return dp[s.length()][t.length()];
        int count=0;
        if(s.charAt(0)==t.charAt(0))
        {
            count+=helper(s.substring(1),t.substring(1),dp);
        } 
        count+=helper(s.substring(1),t,dp);
        dp[s.length()][t.length()]=count;
        return count;
    }
}
