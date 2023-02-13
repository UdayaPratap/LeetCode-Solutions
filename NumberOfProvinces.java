/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
*/
class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        int count=0;
        boolean visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                count++;
                dfs(adj, i, visited);
            }
        }
        return count;
    }
    void dfs(int[][] adj, int src, boolean[] visited)
    {
        visited[src]=true;
        for(int i=0;i<adj.length;i++)
        {
            if(!visited[i] && adj[src][i]!=0) dfs(adj, i, visited);
        }
    }
}
