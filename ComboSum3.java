/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
*/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums, 0, k, n, new ArrayList<Integer>(), ans);
        return ans;
    }
    void helper(int[] nums, int i, int k, int n, List<Integer> curr, List<List<Integer>> ans){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(n==0 || k==0 || i==nums.length) return;
        //not picking
        helper(nums, i+1, k, n, curr, ans);
        //pick
        if(nums[i]<= n){
            curr.add(nums[i]);
            helper(nums, i+1, k-1, n-nums[i], curr, ans);
            curr.remove(curr.size()-1);
        }

    }
}
