/*
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, new ArrayList<Integer>(), nums, 0, new boolean[nums.length]);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums, int i, boolean[] visited)
    {
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        //dont pick curr
        helper(ans, curr, nums, i+1, visited);
        //pick
        if(i>0 && nums[i-1]==nums[i] && !visited[i-1]) return; //if nums[i-1] is not marked visited then that means it has already been processed for current pos and marked false again, hence no need to do again with nums[i],, if it was marked visited then that would mean it was used for another position, not current, hence then we would continue to add the present nums[i]
        visited[i]=true;
        curr.add(nums[i]);
        helper(ans, curr, nums, i+1, visited);
        curr.remove(curr.size()-1);
        visited[i]=false;
    }
}
