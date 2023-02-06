/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<Integer>(), ans, new boolean[nums.length]);
        return ans;
    }
    void helper(int []nums, List<Integer> curr, List<List<Integer>> ans, boolean visited[])
    {
        if(curr.size()==nums.length)
        {
            ans.add(new ArrayList<Integer>(curr));
            return;
        }

        
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]) continue;
            if(i>0 && !visited[i-1] && nums[i]==nums[i-1]) continue;
            
                visited[i]=true;
                curr.add(nums[i]);
                helper(nums, curr, ans, visited);
                curr.remove(curr.size()-1);
                visited[i]=false;
           
        }
        return;
    }
}
