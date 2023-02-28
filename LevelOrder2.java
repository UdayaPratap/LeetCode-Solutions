/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root, 0, ans);
        Collections.reverse(ans);
        return ans;
    }
    public void helper(TreeNode root,int level,List<List<Integer>> ans)
    {
        if(root==null){
            return;
        }
        helper(root.left,level+1,ans);
        while(ans.size()<=level)
            ans.add(new ArrayList<Integer>());
        ans.get(level).add(root.val);
        helper(root.right,level+1,ans);
    }
}
