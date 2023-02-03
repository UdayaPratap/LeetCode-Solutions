/*
The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:

A chess knight can move as indicated in the chess diagram below:


We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).


Given an integer n, return how many distinct phone numbers of length n we can dial.

You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

As the answer may be very large, return the answer modulo 109 + 7.
*/
class Solution {
    int[][] next= {{4,6},{6,8},{7,9},{4,8},{0,3,7},{},{0,1,7},{2,6},{1,3},{2,4}};
    int mod = 1000000007;
    public int helper(int len, int digit, Integer[][] dp){
        if(len==0)
            return 1;
        if(dp[len][digit] != null)
            return dp[len][digit];
        int ans = 0;
        for(int i: next[digit]) {
            ans = (ans%mod + helper(len-1, i, dp)%mod)%mod;
        }
        return dp[len][digit] = ans;
    }
    
    public int knightDialer(int n) {
        int ans = 0;
        Integer[][] dp = new Integer[n+1][10];
        for(int i=0;i<10;i++){
            ans = (ans%mod + helper(n-1, i, dp)%mod)%mod;
        }
        return ans;
    }
}
