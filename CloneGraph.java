/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.*/
/*
class Solution {

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        var visited = new HashMap<Node, Node>();
        var copy = new Node(node.val);
        helper(node, copy, visited);
        return copy;
    }
    private void helper(Node node, Node copy, Map<Node, Node> visited) {

        if (!visited.containsKey(node)) {
            visited.put(node, copy);
            for (Node t : node.neighbors) {
                var copyChild = visited.getOrDefault(t, new Node(t.val));
                copy.neighbors.add(copyChild);
            
                helper(t, copyChild, visited);
            }
        }
    }
}
