/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
 */
class Solution {
    int[][][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][3][2];
        for(int i=0; i<prices.length; i++)
            for(int j=0; j<2+1; j++)
                for(int m=0; m<2; m++)
                    memo[i][j][m] = -1;
        
        return helper(prices, 0, false, 2);
    }
    
    int helper(int[] prices, int idx, boolean isBought, int tran)
    {
        if(idx >= prices.length || tran == 0)
            return 0;
        
        // DP
        int bought = isBought == true ? 1 : 0;
        if(memo[idx][tran][bought] != -1)
            return memo[idx][tran][bought];
        
        // Do nothing
        int profit = helper(prices, idx+1, isBought, tran);
        
        if(isBought)    // Sell share
            profit = Math.max(profit, helper(prices, idx+1, false, tran-1) + prices[idx]);
        
        // Buy share
        profit = Math.max(profit, helper(prices, idx+1, true, tran) - prices[idx]);
        
        memo[idx][tran][bought] = profit;
        return profit;
    }
}
