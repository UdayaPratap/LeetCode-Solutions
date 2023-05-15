/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        helper(root, ans, 0);
        return ans;
    }
    void helper(TreeNode root, List<Integer> ans, int level)
    {
        if(root==null) return;
        if(level==ans.size())ans.add(root.val); //curr level view to be added
         helper(root.right, ans, level+1);
        helper(root.left, ans, level+1);
    }
    
}
