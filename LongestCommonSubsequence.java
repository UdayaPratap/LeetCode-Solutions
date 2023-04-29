/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
*/
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        dp=new int[m][n];
        for(int t[]: dp) Arrays.fill(t, -1);
        return helper(text1, text2, m-1, n-1);
    }
    int helper(String a, String b, int i, int j)
    {
        if(i==-1|| j==-1)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j))
            return dp[i][j]=1+helper(a, b, i-1, j-1);
        
        return dp[i][j]=Math.max(helper(a, b, i-1, j), helper(a, b, i, j-1));
    }
}
