/*
You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes are numbered from 0 to n - 1 (inclusive).

You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.

Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.

A node u is an ancestor of another node v if u can reach v via a set of edges.
  */
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] adj=new List[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] t: edges){
            adj[t[1]].add(t[0]);
        }
        List<List<Integer>> ans=new ArrayList();
        for(int i=0; i<n; i++){
            Set vis=new HashSet();
            vis.add(i);
            List<Integer> curr=new ArrayList();
            dfs(i, adj, vis, curr);
            Collections.sort(curr);
            ans.add(curr);
        }
        return ans;
    }
    void dfs(int u, List<Integer>[] adj, Set<Integer> vis, List<Integer> curr){
        for(int t: adj[u]){
            if(!vis.contains(t)){
                vis.add(t);
                curr.add(t);
                dfs(t, adj, vis, curr);
            }
        }
        

    }
}
