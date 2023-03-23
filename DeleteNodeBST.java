/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key){
             root.right=deleteNode(root.right, key);
             return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left, key);
            return root;
        }
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        TreeNode replacement=goLeft(root.right);
        root.val=replacement.val;
        root.right=deleteNode(root.right, root.val);
        return root;
    }
    TreeNode goLeft(TreeNode root)
    {
        while(root.left!=null) root=root.left;
        return root;
    }
}
