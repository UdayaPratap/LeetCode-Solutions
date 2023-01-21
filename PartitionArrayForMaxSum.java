/*
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[] = new int[n];
        dp[0]=arr[0];
        int currMax=arr[0];
        for(int i=1;i<k;i++)
        {
            if(arr[i]>currMax)
                currMax=arr[i];
            dp[i]=currMax*(i+1);
        }
        
        for(int i=k;i<n;i++)
        {
            currMax=arr[i];
            for(int j=1;j<=k;j++){
                if(arr[i-j+1]>currMax)
                    currMax=arr[i-j+1];
                // cur is the candidate for the solution to memo[i] as we backtrack the K-1 window.
                int cur=currMax*j+dp[i-j];
                if(cur>dp[i])
                    dp[i]=cur;
            }
        }
        return dp[n-1];
    }
}
