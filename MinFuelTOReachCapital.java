/*
There is a tree (i.e., a connected, undirected graph with no cycles) structure country network consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0. You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.

There is a meeting for the representatives of each city. The meeting is in the capital city.

There is a car in each city. You are given an integer seats that indicates the number of seats in each car.

A representative can use the car in their city to travel or change the car and ride with another representative. The cost of traveling between two cities is one liter of fuel.

Return the minimum number of liters of fuel to reach the capital city.
  */
class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] adj= new List[roads.length+1];
        int[] deg=new int[roads.length+1];
        for(int i=0; i<=roads.length; i++){
            adj[i]=new ArrayList<>();
        }
        for(int [] t: roads){
            adj[t[0]].add(t[1]);
            adj[t[1]].add(t[0]);
            deg[t[0]]++;
            deg[t[1]]++;
        }
        return bfs(adj, deg, seats);
    }
    long bfs(List<Integer>[] adj, int[] deg, double seats){
        long ans=0;
        Queue<Integer> q=new LinkedList();
        for(int i=1; i<deg.length; i++) if(deg[i]==1) q.add(i); //add leaf cities
        int[] counter=new int[deg.length]; //counts representatives passing through a city

        while(!q.isEmpty()){
            int curr=q.poll(); //pick a city
            counter[curr]++; //add rep of curr city to the counter
            for(int t: adj[curr]){
                if(deg[t]==0) continue;
                counter[t]+=counter[curr]; //add reps of parent city to counter of t as they pass through that city
                ans+=Math.ceil(counter[curr]/seats); //calculate liters
                deg[t]--; //reduce degree as parent city is not needed anymore
                if(deg[t]==1 && t!=0) q.add(t); 
            }
            deg[curr]=0;
        }
        return ans;
    }
}
