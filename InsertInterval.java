/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
  */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans=new ArrayList<>();
        int n=intervals.length;
        int idx=0;
        //add elements started before newInterval
        for(idx=0; idx<n; idx++){
            if(intervals[idx][0]<newInterval[0]) ans.add(intervals[idx]);
            else break;
        }
        //check condition for merging new interval
        if(ans.size()==0 || (newInterval[0]>ans.get(ans.size()-1)[1])) 
            ans.add(newInterval);
         else{
        int[] lastInterval=ans.get(ans.size()-1);
        lastInterval[1]=Math.max(lastInterval[1], newInterval[1]);
        }
        //add elements remaining after newInterval
        while(idx<intervals.length){
            int[] lastInterval=ans.get(ans.size()-1);
            if(lastInterval[1]>= intervals[idx][0]) 
                lastInterval[1]=Math.max(lastInterval[1], intervals[idx][1]);
            else ans.add(intervals[idx]);
            idx++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}