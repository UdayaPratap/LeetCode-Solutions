/*
An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

'A': Absent.
'L': Late.
'P': Present.
Any student is eligible for an attendance award if they meet both of the following criteria:

The student was absent ('A') for strictly fewer than 2 days total.
The student was never late ('L') for 3 or more consecutive days.
Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.
*/
class Solution {
    public int checkRecord(int n) {
        int[][][] memo=new int[n+1][2][3];
        for(int[][] c1 : memo)
        for(int[] c2 : c1)
            Arrays.fill(c2,-1);
        return helper(n, 0, 0, memo);
    }
    final int MOD=1000000007;
    int helper(int n, int absent, int lateStreak, int[][][] memo)
    {
        if(n==0) return 1;
        if(memo[n][absent][lateStreak]!=-1)   return memo[n][absent][lateStreak]%MOD;
        int count=0;
        // we are seeing only ways in which he is still eligible
        // regular day
        count=(count+helper(n-1, absent, 0, memo)%MOD)%MOD;

        //absent
        if(absent<1)
        count=(count+helper(n-1, absent+1, 0, memo)%MOD)%MOD;

        //late
        if(lateStreak<2)
        count=(count+helper(n-1, absent, lateStreak+1, memo)%MOD)%MOD;

        return memo[n][absent][lateStreak]=count%MOD;

    }
}
