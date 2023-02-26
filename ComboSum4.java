/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 */
METHOD 1: MEMO
class Solution {
    private int[] dp;

public int combinationSum4(int[] nums, int target) {
    dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return helper(nums, target);
}

private int helper(int[] nums, int target) {
    if (dp[target] != -1) {
        return dp[target];
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
        if (target >= nums[i]) {
            res += helper(nums, target - nums[i]);
        }
    }
    dp[target] = res;
    return res;
}
}
METHOD 2: DP
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<nums.length; j++)
            {
                if(i-nums[j]>=0) dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }
}
