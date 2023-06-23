/*You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map=makeGraph(equations, values);
        //map: <numerator, <denominator, result>>

        double[] ans=new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            ans[i]=dfs(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<String>());
        }
        return ans;
    }
    double dfs(String src, String dest, Map<String, Map<String, Double>> map, Set<String> visited)
    {
        if(!map.containsKey(src)) return -1.0;
        if(map.get(src).containsKey(dest)) return map.get(src).get(dest);
        visited.add(src);
        Map<String, Double> curr=map.get(src);
        for(String t: curr.keySet()){
            if(!visited.contains(t)){
                double weight=dfs(t, dest, map, visited);
                if(weight!=-1.0) return weight*curr.get(t); //answer is division of src and t mult by weight(chain division resulting in multiplication)
            }
        }
        return -1.0;
    }
    Map<String, Map<String, Double>> makeGraph(List<List<String>> eq, double[] values){
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u, v;
        
        for(int i = 0; i < eq.size(); i++){
            u = eq.get(i).get(0);
            v = eq.get(i).get(1);
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1/values[i]);
            
        }
        return graph;
    }
}
