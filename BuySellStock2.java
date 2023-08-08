/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
  */
class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo= new int[prices.length][2];
        for(int[] t: memo) Arrays.fill(t, -1);
        return helper(prices, 0, 0, memo);
    }
    int helper(int[] prices, int i, int bought, int[][] memo){
        
        if(i==prices.length) return 0;
        if(memo[i][bought]!=-1) return memo[i][bought];
        if(bought==1){
            return memo[i][bought]=Math.max(prices[i]+helper(prices, i+1, 0, memo), helper(prices, i+1, bought, memo));
        }
        return memo[i][bought]=Math.max(-prices[i]+helper(prices, i+1, 1, memo), helper(prices, i+1, bought, memo));
    }
}
