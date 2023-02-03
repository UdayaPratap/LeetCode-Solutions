/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs=new ArrayList<>();
        backtrack(1,n,k,new ArrayList<Integer>(), combs);
        return combs;
    }
    void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> combs)
    {
        if(k==0){
            combs.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i=start; i<=n; i++)
        {
            curr.add(i);
            backtrack(i+1,n,k-1,curr,combs);
            curr.remove(curr.size()-1);
        }
        return;
    }
}
