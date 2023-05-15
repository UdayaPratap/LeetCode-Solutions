/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
*/
class Solution {
    //1. use min heap to store {element, freq(element)} data comparing using frequencies.
    //2. When heap size exceeds k then poll to remove min freq data. 
    //3. This way at the end min heap will contain k most frequent elements.
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int t: nums) map.put(t, map.getOrDefault(t, 0)+1);
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[1], b[1]);
    }
});
        for(Integer t: map.keySet()){
            pq.add(new int[]{t, map.get(t)});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int ans[]=new int[k];
        int i=0;
        while(!pq.isEmpty())
        {
            ans[i]=pq.poll()[0];
            i++;
        }
        return ans;
    }
}
