/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
*/
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
         List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
        graph[i] = new ArrayList<>();
    }

    for (int[] dislike : dislikes) {
        graph[dislike[0]].add(dislike[1]);
        graph[dislike[1]].add(dislike[0]);
    }
    //made graph till here
    int[] colors = new int[n + 1];
    //0 not assigned a set
    //1 is first set
    //-1 is second set

    for(int i=1; i<=n; i++)
    {
        if(colors[i]==0 && !paint(colors, i, graph, 1)) return false; //if any node is not painted yet and cant be painted in required color then false
            
    }
    return true;
    }
    //paint function checks if node can be painted in required color passed as int color
    //if yes then it paints it in req color and return true
    //else return false
    boolean paint(int[] colors, int node, List<Integer>[] graph, int color){
        if(colors[node]!=0){
            return colors[node]==color; //if already painted check if it is correct paint
        }
        colors[node]=color;
        for (int adj : graph[node]) {
        if (!paint(colors, adj, graph, -color)) {
            return false;
            }
        }
        return true;
    }
}
