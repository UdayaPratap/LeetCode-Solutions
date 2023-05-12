/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, new ArrayList<Integer>(), new boolean[nums.length], nums);
        return ans;
    }
    void helper(List<List<Integer>> ans, List<Integer> curr, boolean[] visited, int[] nums)
    {
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(visited[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !visited[i-1]) continue;
            visited[i]=true;
            curr.add(nums[i]);
            helper(ans, curr, visited, nums);
            visited[i]=false;
            curr.remove(curr.size()-1);
        }
    }
}
