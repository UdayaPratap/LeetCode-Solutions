/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 
 */
class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer>[] adj=new ArrayList[n];
        int[] indegree=new int[n];
        for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
        for(int[] t: pre){
            //adj[course] contains courses that have course as prereq
            adj[t[0]].add(t[1]);
        }
        for(int i=0; i<n; i++) for(int t : adj[i]) indegree[t]++;
        //increase the indegree of courses that have i as prereq
        return bfsTopo(adj, indegree, n);        
    }
    boolean bfsTopo(List<Integer>[] adj, int[] indegree, int n){
        Queue<Integer> q=new LinkedList();
        for(int i=0; i<n; i++) if(indegree[i]==0) q.add(i);
        //add courses with no prereqs to q as we can start from those at any time
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int t: adj[curr]){
                indegree[t]--;
                if(indegree[t]==0) q.add(t);
            }
        }
        return count==n? true: false;
    }
}
