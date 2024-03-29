/*
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[][] adj =new int[rooms.size()][rooms.size()];
        for(int i=0; i<rooms.size(); i++)
        {
            for(int j=0; j<rooms.get(i).size(); j++)
                adj[i][rooms.get(i).get(j)]=1;
        }
        boolean[] visited=new boolean[adj.length];
        dfs(adj, 0, visited);
        for(boolean t: visited) if(t==false) return false;
        return true;
    }
    void dfs(int[][] adj, int u, boolean[] visited)
    {
        visited[u]=true;
        for(int i=0; i<adj.length; i++)
        {
            if(adj[u][i]==1 && !visited[i]) dfs(adj, i, visited);
        }
    }
}
