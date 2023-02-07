/*
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 
*/

class Solution {
    class Job implements Comparable<Job>{
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
        public int compareTo(Job otherJob) {
            return this.start - otherJob.start;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs=new Job[n];
        for(int i=0;i<n;i++) jobs[i]=new Job(startTime[i], endTime[i], profit[i]);
        Arrays.sort(jobs); //sort by start time using custom comparator in class
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return helper(jobs, 0, dp);
    }
    int helper(Job[] jobs, int idx, int dp[])
    {
        if(idx==jobs.length) return 0; //all jobs done
        if(dp[idx]!=-1) return dp[idx];

        int i=idx+1;
        while(i<jobs.length && jobs[i].start<jobs[idx].end)   i++; //skip jobs that cant be started IF idx job is started

        return dp[idx]=Math.max(jobs[idx].profit+helper(jobs, i, dp), helper(jobs, idx+1, dp) );
        //choose max b/w if currjob started and next ith started or curr not started and next started
    }
}
