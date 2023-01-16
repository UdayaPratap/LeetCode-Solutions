/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 
 
*/
class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        if(nums.length<2)
            return nums[0];
        dp[0]=nums[0]; dp[1]=nums[1];
        for(int i=2;i<nums.length;i++)
        {
            int minus2=dp[i-2];
            int minus3=0;
            if(i-3>=0)
                minus3=dp[i-3];
            dp[i]=nums[i] + Math.max(minus2,minus3);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }
}
