/*
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    int helper(int[] nums, int i, int[] dp)
    {
        if(i==nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        //dont delete current
        int a1=helper(nums, i+1, dp);
        //delete current
        //total sum of all occurences of current ith value
        int sum=0, j=i;
        while(j<nums.length && nums[j]==nums[i]){
            sum+=nums[j];
            j++;
        }
        //skip next as we cant include it
        while(j<nums.length && nums[j]==nums[i]+1) j++;
        int a2=sum+helper(nums, j, dp);
        return dp[i]=Math.max(a1, a2);

    }
}
