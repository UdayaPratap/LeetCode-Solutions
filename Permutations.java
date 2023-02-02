/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new LinkedList<>();
         List<Integer> dt =new LinkedList<>();
        for(int t:nums)
            dt.add(t);

        helper(res, new LinkedList<Integer>(),dt);
        return res;
    }
    void  helper(List<List<Integer>> res,List<Integer> perm, List<Integer> dt)
    {
        if(dt.size()==0){
            res.add(perm);
            return;
        }
        for(Integer t: dt)
        {
            List<Integer> tempPerm=new LinkedList<>(perm);
             List<Integer> tempDt=new LinkedList<>(dt);
             tempPerm.add(t);
             tempDt.remove(t);
             helper(res,tempPerm,tempDt);
        }
    }
}
