/*
You have n dice, and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
*/
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int t[]: dp) Arrays.fill(t, -1);
        return helper(n, k, target, dp);
    }
    static int MOD= 1000000007;
    int helper(int n, int k, int target, int[][] dp)
    {
        if(target==0 && n==0) return 1;
        if(n<=0 || target<0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int count=0;
        for(int i=1; i<=k; i++)
        {
            if(i<=target)
                count= (count+helper(n-1, k, target-i, dp))%MOD;
        }
        return dp[n][target]=count;
    }
    // public int numRollsToTarget(int n, int k, int target) {
    //     int[][] dp=new int[n+1][target+1];
    //     dp[0][0]=1;
    //     for(int i=1; i<=n; i++)
    //         for(int j=1; j<=target; j++)
    //         {
    //             int curr_target=j;
    //             int count=0;
    //              for(int s=1; s<=k; s++)
    //             {
    //                 if(s>curr_target) break;
    //                 count=(count+dp[i-1][curr_target-s])%MOD;
    //             }
    //             dp[i][j]=count;
    //         }
    //     return dp[n][target];              
    // }
}

