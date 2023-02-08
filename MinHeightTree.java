/*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(n==0) return res;
        if(n==1)
        {
            res.add(0);
            return res;
        }
        //degree to count number of connected vertices to i
        int degree[]=new int[n];
        //create adj list
        List<List<Integer>> adj=new ArrayList<>();
         for(int i=0;i<n;i++)
         {
             adj.add(new ArrayList<>()); 
         }
         for(int[] e: edges)
         {
             degree[e[0]]++;
             degree[e[1]]++;
             adj.get(e[0]).add(e[1]);
             adj.get(e[1]).add(e[0]);
         }

        //q for bfs
         Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<n;i++)
         {
             if(degree[i]==1) //if leaf add to q
             {
                 q.add(i);
             }
         }
         while(n>2) //do till only 2 nodes left
         {
             int size=q.size();
             n-=size;
             while(size-->0) //while q is not empty
             {
                 int v=q.poll();
                 for(int i: adj.get(v))
                 {
                     degree[i]--; 
                     //if after removing one leaf node, another has degree 1 i.e. new leaf, add to q
                     if(degree[i]==1) q.add(i);
                 }
             }
         }
         //nodes obtained after removing all leaf nodes are ans
         res.addAll(q);
         return res;
    }
}
