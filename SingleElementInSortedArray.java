/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0, right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(mid%2==1) mid--; //if odd, make it even so it points to beginning of possible pair
            if(nums[mid]!=nums[mid+1]) right=mid;
            else left=mid+2;
        }
        return nums[left];
    }
}
