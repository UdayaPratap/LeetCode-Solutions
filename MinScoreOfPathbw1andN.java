/*
You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.

Return the minimum possible score of a path between cities 1 and n.

Note:

A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
  */
class Solution {
    List<int[]>[] adj;
    int ans = 10001;
    boolean[] vis;
    public int minScore(int n, int[][] roads) {
        adj = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            adj[r[0]].add(new int[] {r[1], r[2]});
            adj[r[1]].add(new int[] {r[0], r[2]});
        }

        vis = new boolean[n + 1];
        vis[1] = true;

        dfs(1);
        return ans;
    }

    private void dfs(int curr) {
        for (int[] nei : adj[curr]) {
            int next = nei[0], dist = nei[1];
            ans = Math.min(ans, dist);
            if (!vis[next]) {
                vis[next] = true;
                dfs(next);
            }
        }
    }
}
