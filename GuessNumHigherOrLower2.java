/*
We are playing the Guessing Game. The game will work as follows:

I pick a number between 1 and n.
You guess a number.
If you guess the right number, you win the game.
If you guess the wrong number, then I will tell you whether the number I picked is higher or lower, and you will continue guessing.
Every time you guess a wrong number x, you will pay x dollars. If you run out of money, you lose the game.
Given a particular n, return the minimum amount of money you need to guarantee a win regardless of what number I pick.
*/
]class Solution {
    public int getMoneyAmount(int n) {
          int[][] dp = new int[n+1][n+1];
        return helper(1,n,dp);
    }
    int helper(int left,int right,int[][] dp)
    {
        if(left==right) return 0;
        if(left+1==right)   return left;
        if(dp[left][right]>0) return dp[left][right];
         int ans = Integer.MAX_VALUE;
        for(int i=left+1;i<right;i++)
            ans=Math.min(ans,i+Math.max(helper(left,i-1,dp),helper(i+1,right,dp)));
        dp[left][right]=ans;
        return ans;    
    }
}
