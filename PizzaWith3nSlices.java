/*
There is a pizza with 3n slices of varying size, you and your friends will take slices of pizza as follows:

You will pick any pizza slice.
Your friend Alice will pick the next slice in the anti-clockwise direction of your pick.
Your friend Bob will pick the next slice in the clockwise direction of your pick.
Repeat until there are no more slices of pizzas.
Given an integer array slices that represent the sizes of the pizza slices in a clockwise direction, return the maximum possible sum of slice sizes that you can pick.
*/
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        dp=new int[n+1][n+1][n/3 + 1];
        //pass n/3 as noOfSlices w.r.t. me as i can only pick n/3 out of total n slices.
        //left and right is the window from which we can pick after excluding alice and bobs picked ones.
        int pick0th=helper(0, n-2, slices, n/3);
        int pick1st=helper(1, n-1, slices, n/3);
        
        return Math.max(pick0th, pick1st);
        
    }
    int dp[][][];
    int helper( int left, int right, int slices[], int noOfSlices)
    {
        int n=slices.length;
        if( left>right || noOfSlices==0 ) return 0;
        if(dp[left][right][noOfSlices]!=0) return dp[left][right][noOfSlices];
        //dont take ith
        int notTake=helper(left+1,right, slices, noOfSlices);
        //take ith
        int take=slices[left]+helper(left+2, right, slices, noOfSlices-1);
        return dp[left][right][noOfSlices]=Math.max(take, notTake);
    }
}
