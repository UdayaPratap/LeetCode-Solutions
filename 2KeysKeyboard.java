/*
There is only one character 'A' on the screen of a notepad. You can perform one of two operations on this notepad for each step:

Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
Paste: You can paste the characters which are copied last time.
Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
*/
class Solution {
    public int minSteps(int n) {
        int[][] dp=new int[n+1][n+1];
        for(int[] t: dp) Arrays.fill(t,-1);
        return helper(1, 0, n, dp);
    }
    int helper(int notepad, int copy, int n, int dp[][])
    {
        if(notepad>n) return 999999;
        if(dp[notepad][copy]!=-1) return dp[notepad][copy];
        if(notepad==n) return 0; //no more ops needed...
        
        
        //firstly nothing copied, so copy
        if(copy==0){
            return dp[notepad][copy]=1+helper(notepad, notepad, n, dp);
        }

        //something already copied
        if(copy==notepad) // same copy as notepad so copying is redundant hence optimal to paste
        {
            return dp[notepad][copy]=1+helper(notepad+copy, copy, n, dp );
        }
        //do both take min
        int copied=helper(notepad, notepad, n , dp);
        int pasted=helper(notepad+copy, copy, n, dp);
        dp[notepad][copy]=1+Math.min(copied, pasted);
        return dp[notepad][copy];
    }
}
