/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
*/
class Solution {
    public int removeStones(int[][] stones) {
     Set<int[]> visited= new HashSet<>();
     int islands=0;
     for(int[] t: stones)
     {
         if(!visited.contains(t)){
             islands++;
             dfs(t, visited, stones);
         }
     }
     return stones.length-islands; // total stones- groups of stones grouped by common row or col   
    }
    void dfs(int[] t, Set<int[]> visited, int[][] stones){
        visited.add(t);
        for(int[] u: stones){
            if(!visited.contains(u))
                if(t[0]==u[0] || t[1]==u[1]) //if 2 stones have same row or col
                    dfs(u, visited, stones);
        }
    }
}
