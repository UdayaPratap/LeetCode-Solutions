/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        int dest=n-1;
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        dfs(graph, ans, curr, 0, dest);
        return ans;

    }
    void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> curr,int src, int dest)
    {
        if(src==dest){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        

        for(int i=0;i<graph[src].length;i++)
        {
            if(!curr.contains(graph[src][i]))
            {
                curr.add(graph[src][i]);
                dfs(graph, ans, curr, graph[src][i], dest);
                curr.remove(curr.size()-1);
            }
        }

    }
}
