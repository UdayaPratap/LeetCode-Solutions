/*
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.
*/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo=new Integer[days.length+1];
        return helper(days,0,costs, memo);
    }
    int helper(int[] days, int curr, int[] costs, Integer[] memo)
    {
        if(curr==days.length)  return 0;
        if(memo[curr]!=null) return memo[curr];
        int ret=Integer.MAX_VALUE;
        //buy one day pass
        int covered=curr;
        int temp=costs[0]+helper(days, covered+1,costs,memo);
        ret=Math.min(temp,ret);

        //7 day pass
        covered=curr;
        while(covered+1<days.length &&  days[covered+1]<=days[curr]+6)
            covered++;
        temp=costs[1]+helper(days,covered+1,costs,memo);
        ret=Math.min(temp,ret);

        //30 day pass
        covered=curr;
        while(covered+1<days.length &&  days[covered+1]<=days[curr]+29)
            covered++;
        temp=costs[2]+helper(days,covered+1,costs,memo);
        ret=Math.min(temp,ret);
        memo[curr]=ret;
        return ret;
    }
}
