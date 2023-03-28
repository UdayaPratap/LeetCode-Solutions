/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        if(k==1) return true;
        for(int t: nums) sum+=t;
        if(k>nums.length || sum%k!=0) return false;
        boolean visited[]= new boolean[nums.length];  
	    Arrays.fill(visited,false);
	    return helper(nums,visited,sum/k,0,0,k);
    }
    boolean helper(int[] nums, boolean[] visited, int sum, int curr, int idx, int k)
    {
        if(k==1) return true; //sums made k times
        if(curr==sum) return helper(nums, visited, sum, 0, 0, k-1); //sum made once, do k-1 more times
        
        //sum yet to be made for current turn
        for(int i=idx; i<nums.length; i++)
        {
            if(visited[i] || nums[i]+curr> sum) continue; 
            visited[i]=true;
            if(helper(nums, visited, sum, curr+nums[i], i+1, k)) return true;
            visited[i]=false;
        }
        return false;

    }
}
