/*
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.


Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

 */
class Solution {
    
    public int numTilings(int n) {
        Long[] memo= new Long[n+1];
        return (int)helper(n, memo);
    }
    public long helper(int n, Long[] memo){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(memo[n] != null){
            return memo[n];
        }
        long count = 0;
        count = 2*helper(n-1,memo) + helper(n-3,memo); //by reducing the recurrence relation like:
        /*
        dp[n] = dp[n-1] + dp[n-2] + 2*(dp[n-3] + ...... + dp[0]); -----(1)
        so if try for dp[n-1] we have :- dp[n-1] = dp[n-2] + dp[n-3] + 2*(dp[n-4] +...... + dp[0] ); ----(2)
        subtract (2) from (1) we get :-
        dp[n] - dp [n-1] = dp[n-1] + dp[n-3];
        so dp[n] = dp[n-1] + dp[n-1] + dp[n-3];
        */
        
        return memo[n] = count%1000000007;
}}
