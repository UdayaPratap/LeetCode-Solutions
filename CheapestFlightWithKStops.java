/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>(); //{fro, {to, cost}}
        for (int[] f : flights) {
            adj.putIfAbsent(f[0], new ArrayList<>());
            adj.get(f[0]).add(new int[] {f[1], f[2]});
        }
        int[] stops=new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[1] - b[1]); //use pq insteadd of normal q as it always gives next cheapes path.
        pq.add(new int[]{src, 0, 0}); //{node, cost from src, stops from src}

        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int currNode=curr[0];
            int currCost=curr[1];
            int currStops=curr[2];
            if(currStops>stops[currNode] || currStops>k+1){ 
                //already reached currNode with lesser stops or currStops greater than valid value
                continue;
            }
            stops[currNode]=currStops;
            if(currNode==dest)
                return currCost;
            
            if(!adj.containsKey(currNode))  continue; //no adjacent nodes, cant use this node

            for(int[] next: adj.get(currNode))
            {
                int nextNode=next[0];
                int nextNodeCost=currCost+next[1];
                pq.add(new int[]{nextNode, nextNodeCost, currStops+1});
            }
        }
        return -1;
    }
}
