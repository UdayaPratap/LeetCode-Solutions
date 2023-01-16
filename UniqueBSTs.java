/*
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
*/
class Solution {
    public int numTrees(int n)
    {
        return numTrees(n, new HashMap<Integer, Integer>());
    }
    public int numTrees(int n, HashMap<Integer,Integer> map) {
       if(n==0 || n==1)
        return 1;
        if(map.containsKey(n))
            return map.get(n);

        int ans=0;
        for(int i=1;i<=n;i++)
        {
            if (!map.containsKey(i - 1)) {
            map.put(i - 1, numTrees(i - 1));
            }
            if (!map.containsKey(n - i)) {
            map.put(n - i, numTrees(n - i));
            }
            ans += map.get(i - 1) * map.get(n - i);
        } 
        map.put(n,ans);
        return ans;
    }
}
