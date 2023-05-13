/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> preSum=new HashMap<>();
        int sum=0;
        preSum.put(0,1);
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(preSum.containsKey(sum-k))
            {
                ans+=preSum.get(sum-k);
            }
            preSum.put(sum, preSum.getOrDefault(sum,0)+1);
            
        }
        return ans;
    }
}
