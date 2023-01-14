/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/
class Solution {
    public int coinChange(int[] coins, int amount)
    {   
        if (coins == null || coins.length == 0) 
            return -1;
        
        Integer[] memo=new Integer[amount+1];
        
        return helper(coins,amount,memo);
    }
      public int helper(int[] coins, int amount,Integer[] memo) {
        if (amount == 0) {
        return 0;
        }
        if(memo[amount]!=null)
            return memo[amount];

        int min = Integer.MAX_VALUE;

        for (int t : coins) {
            if (amount < t) {
                continue;
            }
            int temp = helper(coins, amount - t,memo);
            if (temp == -1) {
                continue;
            }
            min = Math.min(min, temp + 1);
        }
        memo[amount]=(min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
  }
}
