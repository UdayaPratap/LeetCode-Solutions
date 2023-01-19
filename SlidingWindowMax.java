/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ret=new ArrayList<>();
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(a->a[0])));
        for(int i=0;i<k;i++){
            pq.add(new int[]{nums[i],i}); //store first 3 elemetns in heap
        }
        
        ret.add(pq.peek()[0]); //add max of first 3 to ret
        int currMax=pq.peek()[0]; //currmax= max of first 3
        
        for(int i=k;i<nums.length;i++){
            pq.add(new int[]{nums[i],i}); //add remaining elements one by one to heap and check max in below while loop
            
            while(pq.peek()[0]==currMax && pq.peek()[1]<=i-k){ //iterate till last slding window
                pq.poll(); //remove the elelement that is out of bounds for current window
                currMax=pq.peek()[0]; //currmax is the max of current window
            }
            currMax=pq.peek()[0]; 
            ret.add(pq.peek()[0]);//add current max to ret
        }
        return ret.stream().mapToInt(x->x).toArray(); //ret to array

    }
}
