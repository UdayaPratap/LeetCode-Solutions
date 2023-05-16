/*
There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:

In each step, you will choose any 3 piles of coins (not necessarily consecutive).
Of your choice, Alice will pick the pile with the maximum number of coins.
You will pick the next pile with the maximum number of coins.
Your friend Bob will pick the last pile.
Repeat until there are no more piles of coins.
Given an array of integers piles where piles[i] is the number of coins in the ith pile.

Return the maximum number of coins that you can have.
*/
class Solution {
    //1 2 3 4 5 6 7 8 9
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum=0;
        int r=piles.length-2;
        int l=piles.length/3;
        for(int i=r; i>=l; i-=2)
        {
            sum+=piles[i];
        }
        return sum;
    }
}
