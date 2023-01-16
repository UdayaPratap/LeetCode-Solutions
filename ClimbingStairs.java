/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
class Solution {
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        return helper(n,memo);
    }
    public int helper(int n,int [] memo)
    {
        if(n==0)
        {
        memo[0]=0;
            return 0;
        }
        if(n==1)
        {
            memo[1]=1;
            return 1;
        }
        if(n==2)
        {
            memo[2]=2;
            return 2;
        }
        if(memo[n]!=0)
        {
            return memo[n];
        }

        memo[n]= helper(n-2,memo)+helper(n-1,memo);
        return memo[n];
    }
}
