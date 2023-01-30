/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.

Return true if and only if Alice wins the game, assuming both players play optimally.
*/
class Solution {
    public boolean divisorGame(int n) {
        if(n==0 || n==1)
            return false;
        boolean[] dp=new boolean[n+1];
        dp[2]=true;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-2] || !dp[i-1];
        }
        return dp[n];

    }
}
