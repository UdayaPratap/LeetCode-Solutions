/*
Given an integer array nums, return the number of all the arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<String, Integer> memo=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                long diff=(long)nums[j]-(long)nums[i];
                ans+=helper(nums,diff,j+1,j,memo); //helper returns sum of all possible subsequences with this difference
            }
        }
        return ans;
    }
    int helper(int[] nums, long diff, int i, int prev,HashMap<String,Integer> memo) 
    {
        if(i>=nums.length || diff<Integer.MIN_VALUE || diff>Integer.MAX_VALUE)
            return 0;
        if(memo.containsKey(diff+" "+i+" "+prev))
            return memo.get(diff+" "+i+" "+prev);
        int ans=0;
        for(int j=i;j<nums.length;j++)
        {
            long currentDiff = (long)nums[j] - (long)nums[prev];
            if(currentDiff==diff)
                ans+=1+helper(nums,diff,j+1,j,memo);
        }
        memo.put(diff+" "+i+" "+prev, ans);
        return ans;
    }
}
