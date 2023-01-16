/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<Integer> ans =new ArrayList<>();
        
        List<Integer> left=inorderTraversal(root.left);
        List<Integer> right=inorderTraversal(root.right);
         ans.addAll(left);
        ans.add(root.val);
         ans.addAll(right);
        return ans;   
    }
}
