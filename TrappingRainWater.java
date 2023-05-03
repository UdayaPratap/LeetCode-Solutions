/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 */
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] maxLeft=new int[n]; //max height to left of ith pos
        maxLeft[0]=height[0];
        int[] maxRight=new int[n]; //max height to right of ith pos
        maxRight[n-1]=height[n-1];
        for(int i=1; i<n; i++)
        {
            maxLeft[i]=Math.max(maxLeft[i-1], height[i]);
            maxRight[n-i-1]=Math.max(maxRight[n-i], height[n-i-1]);
        }
        int ans=0;
        for(int i=0; i<n; i++)
        {
            int temp=Math.min(maxLeft[i], maxRight[i])-height[i];
            ans+= temp<0? 0: temp;
        }
        return ans;
    }
}
