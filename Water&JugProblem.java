/*
You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
*/
class Solution {
    public boolean canMeasureWater(int j1, int j2, int target) {
        if (j1 + j2 < target) return false;
        
        int[] dir=new int[]{j1, -j1, j2, -j2};
        int sum = j1 + j2;
        
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis.add(0);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == target) return true;
            
            for (int t : dir) {
                if (validDir(t, curr, sum) && !vis.contains(curr + t)) {
                    q.offer(curr + t);
                    vis.add(curr + t);
                }
            }   
        }
        
        return false;
    }
    
    private boolean validDir(int c, int el, int sum) {
        return c > 0 && el + c <= sum || c < 0 && el + c >= 0;
    }
}
