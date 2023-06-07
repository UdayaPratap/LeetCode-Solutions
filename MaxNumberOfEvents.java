/*
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.
*/class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->{
            return a[0]-b[0];
        });
        //add ending day of events available on curr day  in pq so we can pick the one ending earliest
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int lastDay=0;
        for(int t[]: events) lastDay=Math.max(lastDay, t[1]);

        int day=1;
        int i=0;
        int count=0;
        while(day<=lastDay){
            //add events on current day
            while(i<events.length && day==events[i][0]) pq.add(events[i++][1]);
            
            //pick event ending earliest for current day
            if(!pq.isEmpty()){
                count++;
                pq.remove();
            }
            //current day done now remove all events ending on or before this day
            while(!pq.isEmpty() && pq.peek()<=day){
                pq.remove();
            }
            day++;
        }
        return count;
    }
}
