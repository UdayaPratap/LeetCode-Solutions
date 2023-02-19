/*
You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.

You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.
*/
class Solution {
    public int tallestBillboard(int[] rods) {
        int n=rods.length;
        dp=new Integer[n+1][10001];
        return helper(0, 0, rods ,n);

    }
    Integer dp[][];
    int center=5000;
    int helper(int i , int diff, int[] rods, int n)
    {
        if(i==n){
            if(diff==0)
            {
                return 0;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[i][center+diff]!=null) return dp[i][center+diff];
        //add to max height pole
    int a=rods[i]+helper(i+1, diff+rods[i], rods, n);
    //add to smaller height pole
    int b=helper(i+1, diff-rods[i], rods, n);
    //dont use
    int c=helper(i+1, diff, rods, n);
    return dp[i][center+diff]=Math.max(a, Math.max(b, c));
    }
    
}
