/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*/
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total=0;
        for(int t: stones)total+=t;
        Integer[][] dp=new Integer[stones.length+1][total];
        return helper(stones, 0, 0, 0, dp);
    }
    int helper(int[] stones, int idx, int lSum, int rSum, Integer[][] dp)
    {
        if(idx==stones.length) return Math.abs(lSum-rSum);
        
        if(dp[idx][lSum]!=null) return dp[idx][lSum];
        return dp[idx][lSum]=Math.min(helper(stones, idx+1, lSum+stones[idx], rSum, dp), helper(stones, idx+1, lSum, rSum+stones[idx], dp));
    }
}
