/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // Fill the arraylists of each nodes with their outgoing edges/connected nodes
        for(int[] pre : prerequisites) {
            adj[pre[0]].add(pre[1]);
        }
        
        // Define an array of visited (0 -> unvisited, 1 -> visited, 2 -> completed), initially filled with 0's 
        int[] visited = new int[numCourses];
        
        // Do DFS for each of the array nodes to check a cycle
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if( !dfs(i, visited, adj, res))
                return new int[0];
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i]=res.get(i);
        
        return ans;
        
    }
    
    public boolean dfs(int u, int[] visited, ArrayList<Integer>[] adj, ArrayList<Integer> curr) {
        // Return false if the node is visited and viewed again before completion
        if(visited[u] == 1)  return false;
        
        // Return true if the node is completed processing
        if(visited[u] == 2)  return true;
        visited[u] = 1;
        for(int n : adj[u]) {
            if(!dfs(n, visited, adj, curr))
                return false;
        }
        visited[u] = 2;
        curr.add(u); //add current element to curr answer if it is comppleted processing
        return true;
    }
} 
