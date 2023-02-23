/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

 
 */

    class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean status[]=new Boolean[graph.length+1]; //dp
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(status[i]!=null && status[i])
                ans.add(i);
            else if(dfs(i,graph,status))
                ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int i, int graph[][],Boolean[] status){
        if(status[i]!=null) return status[i];
        status[i]=false;
        boolean isSafe=true;
        for(int t:graph[i])
            isSafe=isSafe & dfs(t,graph,status);
        return status[i]=isSafe;
    }
}
