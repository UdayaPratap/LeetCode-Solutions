/*
A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.

Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].

Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.

Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
*/
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        
        dp=new int[n+1][n+1];
        for(int t[]: dp) Arrays.fill(t, -1);
        return helper(0, 1, satisfaction);
    }
    int dp[][];
    int helper(int idx, int time, int[] rating)
    {
        if(idx==rating.length) return 0;
        if(dp[idx][time]!=-1) return dp[idx][time];
        //dont make current dish
        int dontMake=helper(idx+1, time, rating);
        //make current dish
        int make= rating[idx]*time + helper(idx+1, time+1, rating);
        return dp[idx][time]=Math.max(make, dontMake);
    }
}
