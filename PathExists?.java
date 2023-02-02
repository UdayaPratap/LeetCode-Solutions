/*
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

 
 */
class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
	return validPath(getAdjList(edges), new HashSet<>(), start, end);
}

private Map<Integer, Set<Integer>> getAdjList(int[][] edges) {
	var adjList = new HashMap<Integer, Set<Integer>>();
	
	for (var edge : edges) {
		adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
		adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
	}
	return adjList;
}

private boolean validPath(Map<Integer, Set<Integer>> adjList, Set<Integer> visited, int current, int end) {
	if (current == end)
		return true;		
	if (!visited.add(current))
		return false;
		
	for (var neighbor : adjList.getOrDefault(current, Set.of()))
		if (validPath(adjList, visited, neighbor, end))
			return true;			
	return false;
}
}
