/*
You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.

Note that the partition must use every integer in nums, and that the score is not necessarily an integer.

Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.
*/
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        return helper(0, sum, k, new Double[nums.length][k + 1]);
    }

    public double helper(int idx, int[] sum, int k, Double[][] memo){
        if(idx == sum.length){
            return Double.MIN_VALUE;
        }
        if(memo[idx][k] != null){
            return memo[idx][k];
        }
        if(k == 1){
            double total = sum[sum.length - 1] - (idx > 0 ? sum[idx - 1] : 0);
            return (double) total / (double)(sum.length - idx);
        }

        double max = Double.MIN_VALUE;
        for(int i = idx; i < sum.length; i++){
            double current = sum[i] - (idx > 0 ? sum[idx - 1] : 0);
            current = (double) current / (double)(i - idx + 1);
            max = Math.max(max, current + helper(i + 1, sum, k - 1, memo));
        }
        memo[idx][k] = max;
        return max;
    }
}
