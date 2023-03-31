/*
A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.

Given an array of integers rollMax and an integer n, return the number of distinct sequences that can be obtained with exact n rolls. Since the answer may be too large, return it modulo 109 + 7.

Two sequences are considered different if at least one element differs from each other.
*/
class Solution {
    long[][][] dp;
    int mod = 1_000_000_007;
    public int dieSimulator(int n, int[] rollMax) {
        dp = new long[n + 1][7][16];
        for(long[][] row: dp)
            for(long[] col: row)
                Arrays.fill(col, -1);
        
        return (int)helper(n, 0, rollMax, 0);
    }
    
    private long helper(int n, int prev, int[] rollMax, int runs)
    {
        if(n == 0)
            return 1;
        
        if(dp[n][prev][runs] != -1)
            return dp[n][prev][runs];
        
        long ans = 0;
        for(int i = 1; i <= 6; i++)
        {
            if(prev != 0 && i == prev && rollMax[i-1] <= runs) 
                continue;
            if(i == prev) 
                ans = (ans + helper(n-1, i, rollMax, runs + 1)) % mod;
            else
                ans = (ans + helper(n-1, i, rollMax, 1)) % mod;
        }
        
        dp[n][prev][runs] = ans;
        return ans;
    }      
}
