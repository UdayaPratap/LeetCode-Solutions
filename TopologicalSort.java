
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] topo=new int[V];
        int[] indegree=new int[V];
        for(int i=0; i<V; i++){
            if(adj.get(i)!=null){
                for(int t: adj.get(i)){
                    indegree[t]++;
                }
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<V; i++) if(indegree[i]==0) q.add(i);
        int idx=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            topo[idx++]=curr;
            for(int t: adj.get(curr)){
                indegree[t]--;
                if(indegree[t]==0) q.add(t);
            }
        }
        return topo;
    }
}
