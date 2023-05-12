/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums, int i)
    {
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        //pick ith element
        curr.add(nums[i]);
        helper(ans, curr, nums, i+1);
        curr.remove(curr.size()-1);
        //dont pick
        helper(ans, curr, nums, i+1);
    }
}
