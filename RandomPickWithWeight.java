/*
You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).
*/
class Solution {
    int[] ranges;
    int rangeMax;
    Random random=new Random();
    public Solution(int[] w) {
        ranges=new int[w.length];
        ranges[0]=w[0];
        for(int i=1; i<w.length; i++)
        {
            ranges[i]=ranges[i-1]+w[i]; //store ending of range of i in range[i]
        }
        rangeMax=ranges[ranges.length-1];
    }
    
    public int pickIndex() {
        
        int i=1+random.nextInt(rangeMax);
        return search(i);
    }
    int search(int idx)
    {
        int start=0, end=ranges.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(ranges[mid]==idx) return mid;
            else if(idx>ranges[mid]) start=mid+1;
            else  end=mid-1;
        }
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
