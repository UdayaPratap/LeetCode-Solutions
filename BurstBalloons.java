/*
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

 */

class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> balloons=new ArrayList<>();
        int dp[][] = new int[nums.length+1][nums.length+1];
        balloons.add(0,1);
        for(int i:nums) balloons.add(i);
        balloons.add(1);
        
        int n = nums.length;
        
        return help(1,n,balloons, dp);
    }
    
    public int help(int i, int j, List<Integer> balloons, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int ret = -1;
        for(int ind=i; ind<=j; ind++){
            int points = balloons.get(i-1)*balloons.get(ind)*balloons.get(j+1) + help(i,ind-1,balloons,dp) + help(ind+1,j,balloons,dp);
            ret = Math.max(ret,points);
        }
        dp[i][j]=ret;
        return ret;
        
    }
}
