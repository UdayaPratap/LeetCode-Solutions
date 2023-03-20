/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        while(k!=0){
            TreeNode curr=st.pop();
            k--;
            if(k==0) return curr.val;
            curr=curr.right;
            while(curr!=null)
            {
                
                st.add(curr);
                curr=curr.left;
            }
        }
        return -1;
    }
}
