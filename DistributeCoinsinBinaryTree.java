/*
You are given the root of a binary tree with n nodes where each node in the tree has node.val coins. There are n coins in total throughout the whole tree.

In one move, we may choose two adjacent nodes and move one coin from one node to another. A move may be from parent to child, or from child to parent.

Return the minimum number of moves required to make every node have exactly one coin.
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
    int moves=0;
    public int distributeCoins(TreeNode root) {
        moves=0;
        helper(root);
        return moves;
    }
    int helper(TreeNode root){
        if(root==null) return 0;
        int left=helper(root.left); //balance of left subtree
        int right=helper(root.right); //right subtree
        moves+=Math.abs(left)+Math.abs(right); //total moves require for subtrees
        return root.val-1+left+right; //return total balance of root
    }
}
