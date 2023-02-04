/*
Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 */
class Solution {
    public int maxSumDivThree(int[] nums) {
        return helper(nums, 0, 0, new int[nums.length+1][]);
    }
    int helper(int[] nums, int idx, int sum)
    {
        if(idx==nums.length){
            if(sum%3==0)    return sum;
            return 0;
        };
        int useCurrent=helper(nums,idx+1,sum+nums[idx]);
        int notUse=helper(nums,idx+1,sum);
        return Math.max(useCurrent, notUse);
    }
}
