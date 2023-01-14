/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 */
class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        return helper(n,dp);
        
    }

    private int helper(int n, int dp[]) {

        if(n==0) {
            return 0;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int prevSq = (int) Math.floor(Math.sqrt(n));
        int sum = Integer.MAX_VALUE;
        for(int i=prevSq;i>=0;i--){
                sum = Math.min(1+helper(n-(i*i),dp),sum);
                dp[n] = sum;
            
        }
        return sum;
    }
}
