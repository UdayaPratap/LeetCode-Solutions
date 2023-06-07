/*/**
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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode level=new TreeNode(-1);
        q.add(root);
        q.add(level);
        int prev=-1;
        boolean oddLevel=false;
        
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.val==-1){
                if(q.isEmpty()) break;
                 if(oddLevel) prev=Integer.MIN_VALUE;
                 else prev=Integer.MAX_VALUE;
                 oddLevel=!oddLevel;
                 q.add(curr);
                 continue;
            }
            if(oddLevel && (curr.val & 1)==1 || !oddLevel && (curr.val & 1)==0) return false;
            if(!oddLevel && curr.val<=prev) return false;
            if(oddLevel && curr.val>=prev) return false;
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right); 
            prev=curr.val;
        }
        return true;
    }
}
