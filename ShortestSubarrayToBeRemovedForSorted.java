/*
Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.

Return the length of the shortest subarray to remove.

A subarray is a contiguous subsequence of the array.
*/
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left=0;
        int n=arr.length;
         while(left<n)
         {
             if(left==n-1) return 0;
             if(arr[left]>arr[left+1]) break;
             left++;
         }
         int ans=n-left-1; //remove everything to right of l
         int right=n-1;
         while(right>=0)
         {
             if(arr[right-1]>arr[right]) break;
             right--;
         }
          ans=Math.min(ans, right); //min from ans and removing all to left of r

         //start i from 0th and j from right index and check for all removable windows in between
         int i=0, j=right;
         while(i<=left && j<n)
         {
             if(arr[i]<=arr[j]){
                 ans=Math.min(ans, j-i-1);
                 i++;
             }else{
                 j++;
             }
         }
         return ans;
         
    }
}
