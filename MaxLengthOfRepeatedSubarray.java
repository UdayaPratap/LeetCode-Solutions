/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
*/
class Solution {
    int ans = 0;
    int[][]dp;
    public int findLength(int[] nums1, int[] nums2) {
         dp = new int[nums1.length][nums2.length];
         for(int t[]: dp) Arrays.fill(t, -1);
        helper(nums1,nums2,0,0);
        return ans;
    }
    public int helper(int[] nums1,int[] nums2,int i, int j){
        if(i==nums1.length || j==nums2.length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0;
        if(nums1[i]==nums2[j]){
            take=1+helper(nums1,nums2,i+1,j+1);
            ans = Math.max(ans,take);
        }
        //if i and jth element not included
        helper(nums1,nums2,i+1,j);
        helper(nums1,nums2,i,j+1);

        return dp[i][j]=take;
    }
}
