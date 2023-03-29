/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
*/
// class Solution {
//     public boolean canJump(int[] nums) {
//         boolean[] visited=new boolean[nums.length];
//         memo=new Boolean[nums.length];
//        return helper(nums, visited, 0);
//     }
//     Boolean[] memo;
//     boolean helper(int[] nums, boolean[] visited, int idx){
//         visited[idx]=true;
//         if(idx==nums.length-1) return true;
//         if(memo[idx]!=null) return memo[idx];
//         for(int rjump=idx; rjump<=idx+nums[idx]; rjump++)
//             if(rjump<nums.length && !visited[rjump] && helper(nums, visited, rjump)) return memo[idx]=true;
//         for(int ljump=idx; ljump>=idx-nums[idx]; ljump--)
//             if(ljump>=0 && !visited[ljump] && helper(nums, visited, ljump)) return memo[idx]= true;
//         return memo[idx]=false;
//     }
// }
//FASTER
class Solution{
    public boolean canJump(int[] nums){
        int n=nums.length;
        int last=n-1;
        for(int i=n-1; i>=0; i--){
            if(i+nums[i]>=last) last=i;
        }
        return last<=0;
    }
}
