/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        return Math.max(rob(nums,false),rob(nums,true));
    }
    public int rob(int[] nums,boolean useFirst) {
        int dp[]=new int[nums.length];
        if(nums.length<2)
            return nums[0];
        dp[0]=nums[0]; dp[1]=nums[1];
        for(int i=2;i<nums.length;i++)
        {
            
            int minus2=0;
            if(i-2==0 && useFirst)
                minus2=dp[0];
            else if(i-2!=0)
                minus2=dp[i-2];
            int minus3=0;
            if(i-3>0)
                minus3=dp[i-3];
            if(i-3==0 && useFirst)
                minus3=dp[0];
            
            dp[i]=nums[i] + Math.max(minus2,minus3);
        }
        if(useFirst)
        {
            if(nums.length-3>=0)
                return Math.max(dp[nums.length-3],dp[nums.length-2]);
            else
                return dp[nums.length-2];
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }

}
