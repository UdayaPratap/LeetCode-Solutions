/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
*/
class Solution {
    //-4 -1 1 2
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length, temp=0;
        int minDiff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0; i<n; i++)
        {
            int left=i+1, right=n-1;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                int diff=Math.abs(target-sum);
                if(sum==target) return sum;
                if(diff<minDiff){
                    minDiff=diff;
                    ans=sum;
                }
                if(sum<target) left++;
                else right--;
            }  
        }
        return ans;
    }
}
