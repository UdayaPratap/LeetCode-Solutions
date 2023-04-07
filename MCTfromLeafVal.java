/*
Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.
*/
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        Integer dp[][]=new Integer[n][n];
        return helper(arr, 0, n-1, dp);
    }
    int helper(int[] arr, int start, int end, Integer[][] dp)
    {
        if(start==end) return 0;
        if(dp[start][end]!=null) return dp[start][end];
        
        int minSum=Integer.MAX_VALUE;
        for(int i=start; i<end;i++)
        {
            int maxLeft=0, maxRight=0;

            for(int j=start; j<=i; j++)
                maxLeft=Math.max(maxLeft, arr[j]); //max element from left subarray
            for(int j=i+1; j<=end; j++)
                maxRight=Math.max(maxRight, arr[j]); //max el from right

            minSum=Math.min(minSum, maxLeft*maxRight /* node val is prod of max leafnodes*/ + helper(arr, start, i, dp) + helper(arr, i+1, end, dp));
        }
        return dp[start][end]=minSum;
    }
}
