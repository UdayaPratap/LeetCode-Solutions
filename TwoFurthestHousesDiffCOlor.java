/*
There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.

Return the maximum distance between two houses with different colors.

The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
*/
class Solution {
    public int maxDistance(int[] colors) {
        int first=colors[0], idx1=0;
        for(int i=0; i<colors.length; i++)
            idx1= colors[i]!=first? i : idx1; 
        int last=colors[colors.length-1], idx2=0;
        for(int i=colors.length-1; i>=0; i--)
            idx2= colors[i]!=last? i : idx2;
        return Math.max(idx1, colors.length-1-idx2);
    }
}
