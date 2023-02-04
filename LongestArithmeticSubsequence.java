/*
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

 
 */

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        if(arr.length==0 ||arr==null ) return 0;
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(arr[0],1);
        int max=1;
        //map: (last element of AP formed: length of AP formed)
        for(int i=1;i<n;i++)
        {
            int prevLen=map.getOrDefault(arr[i]-difference, 0);
            map.put(arr[i],prevLen+1);
            max=Math.max(prevLen+1,max);
        }
        return max;
    }
}
