/*
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
*/
class Solution {
    public int maxScore(int[] nums/*cardPoints changed to nums*/, int k) {
        //take all left by default
        int sum=0;
        for(int i=0; i<k; i++) sum+=nums[i];
        //now use sliding window to remove one left element and insert one right element at a time and check is sum is max
        int ans=sum;
        int n=nums.length;
        for(int i=0; i<k; i++)
        {
            sum-=nums[k-i-1];//remove rightmost of left ended
            sum+=nums[n-1-i]; //add rightmost of right ended
            ans=Math.max(ans, sum);
        }
        return ans;
    }
}
