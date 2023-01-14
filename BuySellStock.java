/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int n=prices.length;
        int sell=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(prices[i]<prices[sell])
            {
                max=Math.max(prices[sell]-prices[i], max);
            }else{
                sell=i;
            }
        }
        return max;
    }
}
