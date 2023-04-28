/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.
*/
class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length+1][nums.length+1];
        for(int[] t: dp) Arrays.fill(t, -1);
        return helper(nums, -1, 0);
    }
    int helper(int[] nums,int last, int idx)
    {
        if(idx==nums.length) return 0;
        if(dp[idx][last+1]!=-1) return dp[idx][last+1];
        //dont pick idx
        int a1=helper(nums, last, idx+1);
        //pick 
        int a2=Integer.MIN_VALUE;
        if(last==-1 || nums[idx]>nums[last])
            a2=1+helper(nums, idx, idx+1);
        return dp[idx][last+1]=Math.max(a2, a1);
    }
}

