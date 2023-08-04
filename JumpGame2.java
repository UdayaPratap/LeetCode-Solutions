/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
*/
class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(0, nums, memo);
    }

    int helper(int i, int[] nums, int[] memo) {
        if (i == nums.length - 1) return 0;
        if (i > nums.length - 1) return Integer.MAX_VALUE;
        if (memo[i] != -1) return memo[i];
        int min = Integer.MAX_VALUE;
        for (int j = nums[i]; j >= 1; j--) {
            min=Math.min(min, helper(i + j, nums, memo));
        }
        if (min != Integer.MAX_VALUE) {
            memo[i] = 1 + min;
        } else {
            memo[i] = Integer.MAX_VALUE;
        }
        return memo[i];
    }
}
