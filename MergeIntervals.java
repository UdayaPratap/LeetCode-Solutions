/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals by starting point
        Arrays.sort(intervals,
         new Comparator<int[]>()
         {  public int compare(int[] a, int[] b)
            { return a[0]-b[0];}
            }
        );
        //make list of answers
        ArrayList<int[]> temp=new ArrayList<>();
        int n=intervals.length;
        int start=intervals[0][0], end=intervals[0][1];
        for(int i=1; i<n; i++){
            if(end>=intervals[i][0]) end=Math.max(end, intervals[i][1]);
            else{
                int[] curr=new int[2];
                curr[0]=start;
                curr[1]=end;
                temp.add(curr);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        //put last answer in list
        int[] curr=new int[2];
                curr[0]=start;
                curr[1]=end;
                temp.add(curr);
        //convert to int[][]
        int[][] ans=new int[temp.size()][];
        ans=temp.toArray(ans);
        return ans;
    }
}
