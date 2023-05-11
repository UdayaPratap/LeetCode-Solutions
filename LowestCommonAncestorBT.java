/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
*/

 
 1. return root if found p or q or null
 2. if recursion on left tree is null => ans was found in right tree
 3. if recursion of right tree is null => ans was found in left tree
 4. if both are not null then ans is current root
 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root; //1.
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left==null) return right; //2.
        if(right==null) return left; //3.
        return root; //4.

    }
}
