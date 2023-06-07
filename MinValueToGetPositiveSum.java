/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.
*/
class Solution {
    public int minStartValue(int[] nums) {
        int sum=0;
        int start=1;
        for(int t: nums){
            sum+=t;
            if(sum<0){
                int temp=-sum+1;
                if(temp>start) start=temp;
            }
        }
        return start;
    }
}
