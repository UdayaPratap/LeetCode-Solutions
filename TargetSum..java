/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> memo=new HashMap<>();
        return knapsack(nums,target,0,memo);
    }
    int knapsack(int[] nums,int target,int i,HashMap<String,Integer> memo)
    {
        if(i==nums.length)
        {
            if(target==0) return 1;
            return 0;
        } 
        if(memo.containsKey(target+" "+i))
            return memo.get(target+" "+i);
        int val=knapsack(nums,target-nums[i],i+1,memo)+knapsack(nums,target+nums[i],i+1,memo);
        memo.put(target+" "+i,val);
        return val;
        
        

    }
}
