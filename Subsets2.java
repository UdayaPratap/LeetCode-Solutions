/*
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> res=new ArrayList<>();
       helper(0, Integer.MIN_VALUE, nums, new ArrayList<Integer>(), res); 
       return res;
    }
    void helper(int idx, int prev, int[] nums, List<Integer> curr, List<List<Integer>>res)
    {
        if(idx==nums.length)
        {
            
            res.add(new ArrayList<>(curr));
            return;
        }
        int val=nums[idx];
        if(val==prev){
            helper(idx+1, prev, nums, curr, res);
            return;
        }
        //pick
        curr.add(val);
        helper(idx+1, prev, nums , curr, res);
        //change lates beginning pick to nums[idx] to avoid duplicates
        prev=nums[idx];
        //dont pick
        curr.remove(curr.size()-1);
        helper(idx+1, prev, nums, curr, res);
        
    }
}
