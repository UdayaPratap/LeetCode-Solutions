/*
There is a group of n members, and a list of various crimes they could commit. The ith crime generates a profit[i] and requires group[i] members to participate in it. If a member participates in one crime, that member can't participate in another crime.

Let's call a profitable scheme any subset of these crimes that generates at least minProfit profit, and the total number of members participating in that subset of crimes is at most n.

Return the number of schemes that can be chosen. Since the answer may be very large, return it modulo 109 + 7.
*/
class Solution {
    int MOD=1000000007;
    class Crime{
        int profit;
        int group;
        public Crime(int p, int g){
            profit=p;
            group=g;
        }
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int N=group.length;
        Crime[] list=new Crime[N];
        dp=new Integer[N+1][101][101];
       for(int i=0;i<N;i++){
           list[i]=new Crime(profit[i], group[i]);
       } 
       return helper(n, 0, list, minProfit, 0, 0);
    }
    Integer[][][] dp;
    int helper(int n, int i, Crime[] list, int minProfit, int grpUsed, int currProfit)
       {
           if(grpUsed>n) return 0;
           if(i==list.length){
               if(n>=grpUsed && currProfit>=minProfit) return 1;
               return 0;
           }
           if(dp[i][grpUsed][currProfit]!=null) return dp[i][grpUsed][currProfit];
           //take
           int b=helper(n, i+1, list, minProfit, grpUsed+list[i].group, Math.min(currProfit+list[i].profit, minProfit))%MOD;
           //notTake
           int a=helper(n, i+1, list, minProfit, grpUsed, currProfit)%MOD;
           

           return dp[i][grpUsed][currProfit]= (a+b)%MOD;
           
       }
}
