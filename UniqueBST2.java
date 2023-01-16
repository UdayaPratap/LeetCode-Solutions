/*
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    List<TreeNode> helper(int a, int n)
    {
        List<TreeNode> ans=new ArrayList<>();
        if(a>n)
            {
                ans.add(null);
                return ans;
            }
        
        for(int i=a;i<=n;i++)
        {
            List<TreeNode> left=helper(a,i-1);
            List<TreeNode> right=helper(i+1,n);
            for(TreeNode leftNode: left)
            {
                for(TreeNode rightNode: right)
                {
                    TreeNode curr=new TreeNode(i);
                    curr.left=leftNode;
                    curr.right=rightNode;
                    ans.add(curr);

                }
            }
        }
        return ans;
    }
}
