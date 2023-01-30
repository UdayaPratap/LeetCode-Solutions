/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.
*/
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[1]-b[1]);
        
        int high=pairs[0][1];
        int low=pairs[0][0];
        int len=1;
        for(int i=1;i<pairs.length;i++)
        {
            if(pairs[i][0]>high)
            {
                high=pairs[i][1];
                len++;
            }
            else if(pairs[i][1]<low)
            {
                low=pairs[i][0];
                len++;
            }
        }
        return len;
    }
}
