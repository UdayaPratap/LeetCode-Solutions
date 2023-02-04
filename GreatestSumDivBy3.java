/*
Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.

 */
//RECURSION TLE
class Solution {
    public int maxSumDivThree(int[] nums) {
        return helper(nums, 0, 0, new int[nums.length+1][]);
    }
    int helper(int[] nums, int idx, int sum)
    {
        if(idx==nums.length){
            if(sum%3==0)    return sum;
            return 0;
        };
        int useCurrent=helper(nums,idx+1,sum+nums[idx]);
        int notUse=helper(nums,idx+1,sum);
        return Math.max(useCurrent, notUse);
    }
}
//DP
class Solution {
   public int maxSumDivThree(int[] nums) {
        int N = nums.length;
        //create array i,j will be max sum from i to end with modulo 3 == j
        int[][] dp = new int[N][3];
        //init with the last array element
        dp[N - 1][nums[N - 1] % 3] = nums[N - 1];
        //starting from the second from the end element do the dp loop
        for (int i = N - 2; i >= 0; i--) {
            //copy max sums from the previous step
            for (int j =0; j < 3; j++)
                dp[i][j] = dp[i +1][j];
            //for each modulo 3 value
            for (int j = 0; j < 3; j++) {
                //get previous sum for modulo j and add nums[i]
                int s = dp[i + 1][j] + nums[i];
                //then put to the s % 3 element max between s and the sum for the same modulo
                //from the previous step
                dp[i][s % 3] = Math.max(s, dp[i][s % 3]);
            }
        }
        return dp[0][0];
   }
}
