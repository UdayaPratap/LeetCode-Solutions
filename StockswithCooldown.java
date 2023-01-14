/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
*/
class Solution {
    public int maxProfit(int[] prices) {
        int[] memo=new int[prices.length+1];
        Arrays.fill(memo,-1);
        return helper( prices,0, memo);
    }
    int helper(int[] prices, int buy,int[] memo)
    {
        if(buy>=prices.length)
            {
                
                return 0;
            }
        if(memo[buy]!=-1)
            return memo[buy];
        int ret=0;
        for(int i=buy+1;i<prices.length;i++)
        {
            if(prices[i]>prices[buy])
            {
                
                int temp= prices[i]-prices[buy]+helper(prices,i+2,memo);
                ret=Math.max(ret,temp);
            }
        }
        int temp=helper(prices,buy+1,memo);
        ret=Math.max(ret,temp);
        memo[buy]=ret;
        return ret;
    }
}
