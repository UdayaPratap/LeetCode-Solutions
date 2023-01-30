/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 
 */
class Solution {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if(sum%2!=0) return false;
        
        sum /= 2;
        
       Boolean memo[][] = new Boolean[n+1][sum+1];
        
        return helper(nums,0,sum,memo);
    }
    
    boolean helper(int[] nums, int i, int sum, Boolean memo[][]){
        if(sum==0) return true;
        
        else if(i>=nums.length || sum<0) return false;
        
        if(memo[i][sum]!=null) return memo[i][sum];
        
        return memo[i][sum] =helper(nums,i+1,sum-nums[i],memo) ||
                                helper(nums,i+1,sum,memo);
        
        
    }
}
