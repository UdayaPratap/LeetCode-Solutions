/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[]=new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        
        for(int i=0; i<=k; i++){ //no. of max stops allowed
        int[] temp=Arrays.copyOf(cost, n); //update temp for ith stop instead of directly updating cost array. This way no. of stops is correctly calculated.
            for(int t[]: flights){
                if(cost[t[0]]!=Integer.MAX_VALUE){
                    temp[t[1]]=Math.min(temp[t[1]], cost[t[0]]+t[2]);
                }
            }
            cost=temp;
        }
        return cost[dst]== Integer.MAX_VALUE? -1: cost[dst];
    }
}
