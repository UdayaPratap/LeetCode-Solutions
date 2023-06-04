/*
Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated as 0. The rule is similar if the node does not have a right child.
*/
class Solution {
    class Ret{
        int sum;
        int tiltSum;
        public Ret(int s, int r){
            sum=s;
            tiltSum=r;
        }

    }
    public int findTilt(TreeNode root) {
        return helper(root).tiltSum;
    }
    Ret helper(TreeNode root){
        if(root==null) return new Ret(0, 0);
        Ret left=helper(root.left);
        Ret right=helper(root.right);
        int total=left.sum+right.sum+root.val; //total including curr root val
        int currTilt=Math.abs(left.sum-right.sum); //tilt of curr root
        int tiltSum=left.tiltSum+right.tiltSum+currTilt;
        return new Ret(total, tiltSum);
    }
}
