/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans, new ArrayList<Integer>(), nums);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> curr, int[] nums){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int t : nums){
            if(curr.contains(t)) continue;
            curr.add(t);
            helper(ans, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}
