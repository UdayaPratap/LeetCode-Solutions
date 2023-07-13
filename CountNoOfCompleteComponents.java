/*You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.
  */
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        //create adj list
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] t: edges){
            map.putIfAbsent(t[0], new ArrayList<>());
            map.get(t[0]).add(t[1]);
            map.putIfAbsent(t[1], new ArrayList<>());
            map.get(t[1]).add(t[0]);
        }
        for(int i=0; i<n; i++) map.putIfAbsent(i, new ArrayList<>());

        boolean[] vis=new boolean[map.size()];
        int sum=0;
        for(int t: map.keySet()){
            if(!vis[t]){
                List<Integer> list=new ArrayList<>();
                //get current component's vertex list using dfs
                list=dfs(list, map, t, vis);
                //if only one vertex -> complete 
                if(list.size()==1) sum++;
                //check if all vertices in list have same adj list. If they do, that means all vertices connected to all other vertices-> complete
                else{
                    Collections.sort(list);
                    sum+=connected(list, map);
                }
            }
        }
        return sum;
    }
    List<Integer> dfs(List<Integer> list, Map<Integer, List<Integer>> map, int key, boolean[] vis){
        if(vis[key]) return list;

        vis[key]=true;

        List<Integer> li=new ArrayList<>(list);
        li.add(key);
        for(int i=0; i<map.get(key).size(); i++){
            int adjNode=map.get(key).get(i);
            if(!vis[adjNode]) li=dfs(li, map, adjNode, vis);
        }
        return li;
    }
    int connected(List<Integer> list,Map<Integer,List<Integer>>adjList){
        int count=0;
        for(int t: list){
            List<Integer> adj=new ArrayList<>(adjList.get(t));
            //add element itself to the adj list for comparsion purposes
            adj.add(t);
            Collections.sort(adj);
            //compare all elements in this component to the list of the component
            if(list.equals(adj)) count++;
        }
        //if count is equal to list.size, meaning all elements have path to all other, return 1
        return count==list.size()? 1: 0;
    }
}
