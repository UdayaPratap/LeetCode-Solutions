/*
Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
*/
class Solution {
    public boolean stoneGame(int[] piles) {
        Integer[][] dp =new Integer[piles.length+1][piles.length+1];
        int p1=helper(piles, 0, piles.length-1, dp, true);
        int total=0;
        for(int t: piles) total+=t;
        int p2=total-p1;
        return p1>=p2? true: false;
    }
    int helper(int[] piles, int l, int r, Integer[][] dp, boolean aTurn)
    {
        if(l>=r) return 0;
        if(dp[l][r]!=null) return dp[l][r];
        
        if(aTurn){
            return dp[l][r]=Math.max(piles[l]+helper(piles,l+1,r,dp, !aTurn), piles[r]+helper(piles,l,r-1,dp,!aTurn)); //alice plays optimally
        }
         return dp[l][r]=Math.max(helper(piles,l+1,r,dp, !aTurn), helper(piles,l,r-1,dp,!aTurn)); // bob plays optimally
    }
   
}   
