/*
You are given an integer array nums and an array queries where queries[i] = [vali, indexi].

For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.

Return an integer array answer where answer[i] is the answer to the ith query.
*/
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum=0;
        for(int i=0; i<queries.length; i++) if((nums[i] & 1) == 0) sum+=nums[i];
        int[] ans=new int[nums.length];
        int i=0;
        //queries
        for(int[] q : queries){
            if((nums[q[1]] & 1) == 0) // if nums[i] is even => already included in sum
            {
                sum-=nums[q[1]];
                nums[q[1]]+=q[0];
                if((nums[q[1]] & 1) == 0) sum+=nums[q[1]];
            }
            else
            {
                nums[q[1]]+=q[0];
                if((nums[q[1]] & 1) == 0) sum+=nums[q[1]];
            }
            ans[i++]=sum;
        }
        return ans;
    }
}
