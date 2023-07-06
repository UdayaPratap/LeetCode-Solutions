/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{ return b[0]-a[0];});
        //add first 3 elements to pq
        for(int i=0; i<k; i++) pq.add(new int[]{nums[i], i});
        int currMax=pq.peek()[0]; //max of these 3 elements
        int[] ans=new int[nums.length-k+1];
        int idx=0;
        ans[idx++]=currMax;
        for(int i=k; i<nums.length; i++){
            while(pq.size()>0 && pq.peek()[1]<=(i-k)) pq.remove(); //remove out of bounds elements
            pq.add(new int[]{nums[i], i}); //add ith element for ith window
            ans[idx++]=pq.peek()[0]; //add max of ith window to ans
        }
        return ans;
    }
}
