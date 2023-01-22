/*
You are given an integer array nums. Two players are playing a game with this array: player 1 and player 2.

Player 1 and player 2 take turns, with player 1 starting first. Both players start the game with a score of 0. At each turn, the player takes one of the numbers from either end of the array (i.e., nums[0] or nums[nums.length - 1]) which reduces the size of the array by 1. The player adds the chosen number to their score. The game ends when there are no more elements in the array.

Return true if Player 1 can win the game. If the scores of both players are equal, then player 1 is still the winner, and you should also return true. You may assume that both players are playing optimally.
*/
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int scoreDiff=0;
        boolean p1turn=true;
        int start=0, end=nums.length-1;
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] t:dp)
            Arrays.fill(t,-1);
        int p1= helper(nums,start,end,p1turn,dp);
        int sum=0;
        for(int t:nums)
            sum+=t;
        int p2=sum-p1;
        return p1>=p2? true: false;
        
    }
    int helper(int[] nums, int start, int end, boolean p1turn,int[][] dp)//return p1 score only
    {

        if(start>end){
            return 0;
        }
        if (dp[start][end]!=-1) return dp[start][end];

        if(p1turn)
        {
            
            dp[start][end]=Math.max(nums[start]+helper(nums,start+1,end,false,dp),nums[end]+ helper(nums,start,end-1,false,dp));
            //best play of p1 i.e. most increase of scoreDiff in favor of p1
            return dp[start][end];
        }

        dp[start][end]=Math.min(helper(nums,start+1,end,true,dp),helper(nums,start,end-1,true,dp));
        //worst play of p2 i.e. least decrease of scoreDiff in favor of p2
       
        return dp[start][end];
    }
}
