/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/class Solution {
    public void moveZeroes(int[] nums) {
      int idx=0;
      for(int t: nums) 
        if(t!=0) 
            nums[idx++]=t;

      while(idx<nums.length){
          nums[idx++]=0;
      }
    }
}
