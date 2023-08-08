/*
Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.
  */
class Solution {
    public int getMaxLen(int[] nums) {
        int pos=0, neg=0;
        int ans=0;
        for(int x: nums){
            if(x==0){
                pos=0;
                neg=0;
            }else if(x>0){
                pos++;
                neg= (neg==0) ? 0: neg+1; //if no current negative subaraay then dont increase
            }else{
                int temp=pos;
                pos= (neg==0) ? 0: neg+1;
                neg=temp+1;
            }
            ans=Math.max(ans, pos);
        }
        return ans;
    }
}
