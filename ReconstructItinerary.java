/*
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
*/
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets==null || tickets.isEmpty())
            return new ArrayList<String>();
        Map<String , PriorityQueue<String>> map=new HashMap<>();
        // map: (from, to(lexico min on top of priority q));
        for(int i=0;i<tickets.size();i++)
        {
            String fro=tickets.get(i).get(0);
            String  to=tickets.get(i).get(1);
            if(!map.containsKey(fro))
                map.put(fro, new PriorityQueue<>()); //pq stores all string is lexicographic min order
            map.get(fro).add(to);
        }
        //graph is ready in map
        List<String> ans=new ArrayList<String>();
        dfs(ans, map, "JFK");
        Collections.reverse(ans);
        return ans;

    }
    void dfs(List<String> ans,  Map<String , PriorityQueue<String>> map, String src)
    {
        if(map.get(src)==null || map.get(src).isEmpty())
        {
            ans.add(src); 
            return;
        }
        while(!map.get(src).isEmpty()){
            String to=map.get(src).poll();
             dfs(ans, map, to);
        }
        ans.add(src);
        return;
    }
}
