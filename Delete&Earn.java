/*
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(nums[i],i);
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int t: nums)
            freq.put(t,freq.getOrDefault(t,0)+1);
        int[] memo=new int[n+1];
        return helper(nums,map,freq,memo,0);
    }
    int helper(int[] nums, HashMap<Integer,Integer> map, HashMap<Integer,Integer> freq, int[] memo, int i)
    {
        int n=nums.length;
        if(i==n)
            return 0;
        if(memo[i]!=0)
            return memo[i];
        int del=0; int notdel=0;
        
        notdel=helper(nums,map,freq,memo,i+1);
        if(map.containsKey(nums[i]+1))
        {
            int nextI=map.get(nums[i]+1);
            int v=freq.get(nums[i]);
            del=nums[i]*v+helper(nums,map,freq,memo,nextI+1);
        }else{
            del=nums[i]+helper(nums,map,freq,memo,i+1);
        }
        return memo[i]=Math.max(del,notdel);
    }
}
