/*
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.
*/class Solution {
    public int maxProduct(int[] nums) {
        //product max in left to right
        int prod=1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++ ){
            prod*=nums[i];
            max=Math.max(prod, max);
            if(prod==0) prod=1;
        }
        // go form right to left to get the max out of excluding either one of the left most and right most negative values.
        //when we did left to right we considered product where the first encounter(left-most) negative value was not included, now for right most we need to do right to left
        prod=1;
        for(int i=nums.length-1; i>=0; i--){
            prod*=nums[i];
            max=Math.max(prod, max);
            if(prod==0) prod=1;
        }
        return max;
    }
}
