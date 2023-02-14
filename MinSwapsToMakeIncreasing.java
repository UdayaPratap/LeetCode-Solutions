/*
You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].

For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.

An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].
*/
class Solution {
    int dp[][];
    public int minSwap(int[] nums1, int[] nums2) {
        dp=new int[nums1.length+1][2];
        for(int[] t:dp) Arrays.fill(t, -1);
        return helper(nums1, nums2, -1, -1, 0, 0);
    }
    int helper(int[] nums1, int[] nums2, int prev1, int prev2, int i, int swapped)
    {
        if(i==nums1.length) return 0;
        if(dp[i][swapped]!=-1) return dp[i][swapped];
        int ans=Integer.MAX_VALUE;
        if(nums1[i]>prev1 && nums2[i]>prev2)
        {
            ans=helper(nums1, nums2, nums1[i], nums2[i], i+1, 0);
            //no swap as not needed as of now
        }
        //swap(nums1, nums2, i)
        if(nums2[i]>prev1 && nums1[i]>prev2)
        {
            ans=Math.min(ans,1+ helper(nums1, nums2, nums2[i], nums1[i], i+1, 1));
            //no swap needed but still proceed with swap as if-condition still satisfied, because this may help reduce number of swaps in future elements
        }
        dp[i][swapped]=ans;
        return ans;
    }
}
