/*You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 */

class Solution {
    public int maxProfit(int[] prices, int fee) {
     int memo[][]=new int[prices.length+1][2];
     for(int t[]:memo) Arrays.fill(t,-1);
     return helper(1,0, prices, fee, memo);   
    }
    int helper(int buy, int i,int prices[],int fee, int memo[][]) //buy==1 means have to buy
    {
        if(i>=prices.length) return 0;
        if(memo[i][buy]!=-1) return memo[i][buy];
        int max=-1;
        if(buy==1)
        {
            max=Math.max(helper(0,i+1,prices,fee,memo)-prices[i],helper(1,i+1,prices,fee,memo));
        }else{
            max=Math.max(helper(1,i+1,prices,fee,memo)+prices[i]-fee,helper(0,i+1,prices,fee,memo));
        }
        memo[i][buy]=max;
        return max;
    }
}
