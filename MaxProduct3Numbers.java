/*
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
  */class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //all +ve or all -ve
        int a1=nums[n-1]*nums[n-2]*nums[n-3];
        //both kinds of numbers
        int a2=nums[n-1]*nums[0]*nums[1];
        return Math.max(a1, a2);
    }
}
