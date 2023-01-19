/*
Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
class Solution {
    class Triplet{
        int min;
        int max;
        int sum;
        Triplet(int min, int max, int sum){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    int ans ;
    public int maxSumBST(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    
    Triplet helper(TreeNode root){
        if(root == null){
            return new Triplet(0, 0, 0);
        }
        Triplet leftAns = helper(root.left);
        Triplet rightAns = helper(root.right);
        if(root.left == null && root.right == null){
            ans = Math.max(ans, root.val);
            return new Triplet(root.val, root.val , root.val);
        }
        if(root.left == null && root.val < rightAns.min){
            ans = Math.max(ans, rightAns.sum + root.val);
            return new Triplet(root.val, rightAns.max , rightAns.sum + root.val);
        }
        if(root.right == null && root.val > leftAns.max){
            ans = Math.max(ans, leftAns.sum + root.val);
            return new Triplet(leftAns.min, root.val , leftAns.sum + root.val);
        }
        if(root.val > leftAns.max && root.val < rightAns.min){
            ans = Math.max(ans, leftAns.sum + rightAns.sum + root.val);
            return new Triplet(leftAns.min, rightAns.max, leftAns.sum + rightAns.sum + root.val);
        }
        return new Triplet(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
