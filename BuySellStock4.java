/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp=new Integer[prices.length+1][k+1][2];
        return helper(prices, 0, k, 0, dp);
    }
    int helper(int[] prices, int idx, int k, int own, Integer[][][] dp){
        if(idx==prices.length || k==0) return 0;
        if(dp[idx][k][own]!=null) return dp[idx][k][own];
        int a1=-1,a2=-1,a3=-1;
        //neither nuy nor sell, skip current elements
        a1=helper(prices, idx+1, k, own, dp);
        //if not bought => buy
        if(own==0){
            a2=-prices[idx]+helper(prices, idx+1, k, 1, dp);
        }
        //sell if current is higher than boughAt
        else if(own==1){
             a3=prices[idx]+helper(prices, idx+1, k-1, 0, dp);
        }
        return dp[idx][k][own]=Math.max(a1, Math.max(a2,a3)); 
    }
}
