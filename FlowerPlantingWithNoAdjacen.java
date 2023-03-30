/*
You have n gardens, labeled from 1 to n, and an array paths where paths[i] = [xi, yi] describes a bidirectional path between garden xi to garden yi. In each garden, you want to plant one of 4 types of flowers.

All gardens have at most 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3, or 4. It is guaranteed an answer exists.
*/
class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        //make graph
        Map<Integer,Set<Integer>> graph=new HashMap<>();
        for(int i=0; i<n; i++) graph.put(i, new HashSet<>());
        for(int t[]: paths){
            graph.get(t[0]-1).add(t[1]-1);
            graph.get(t[1]-1).add(t[0]-1);
        }
        
        int []ans=new int[n]; //answer

        //for each garden
        for(int i=0; i<n; i++){
            int[] color=new int[5]; // array to check if color already used in current gardens connections
        for(int t: graph.get(i))// for all gardens connected to i
        {
            color[ans[t]]=1; //mark the color used by t as 1(used)
        }
        //check for unused color
        for(int c=4; c>=1; c--){
            if(color[c]!=1) ans[i]=c; //give unused color to i
        }

        }

        return ans;
    }
    
}
