/*
You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.

You then do the following steps:

If original is found in nums, multiply it by two (i.e., set original = 2 * original).
Otherwise, stop the process.
Repeat this process with the new number as long as you keep finding the number.
Return the final value of original.
*/
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        return bSearch(nums, original);
    }
    int bSearch(int[] nums, int a)
    {
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==a) return bSearch(nums, 2*a);
            else if(nums[mid]<a) right=mid-1;
            else left=mid+1;
        }
        return a/2;
    }
}
