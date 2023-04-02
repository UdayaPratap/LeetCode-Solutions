/*
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

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
    int min;
    public int minDiffInBST(TreeNode root) {
         min = Integer.MAX_VALUE;
        dfs(root, null, null);
        return min;
    }
    void dfs(TreeNode root, Integer low, Integer high)
    {
        if(root==null ) return;
        int ans1= low!=null? root.val-low : Integer.MAX_VALUE;
        int ans2=high!=null? high-root.val : Integer.MAX_VALUE;
        min=Math.min(min, Math.min(ans1, ans2));
        dfs(root.left, low, root.val);
        dfs(root.right, root.val, high);
    }
}
