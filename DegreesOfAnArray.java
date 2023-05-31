/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
*/class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums.length==1) return 1;
        Map<Integer, Integer> first=new HashMap<>(); //first index of element
        Map<Integer, Integer> map=new HashMap<>(); //freq of element
        int maxDeg=0; //maxDegree
        int ans=0; //final array length answer
        for(int i=0; i<nums.length; i++){
            first.putIfAbsent(nums[i], i);
            int freq= map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i], freq);
            if(freq>maxDeg){
                maxDeg=freq;
                ans=i- first.get(nums[i])+1;
            }else if( freq==maxDeg){
                ans=Math.min(ans, i-first.get(nums[i])+1);
            }
        }
        return ans;
    }
}
