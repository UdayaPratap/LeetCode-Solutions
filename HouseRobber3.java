/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
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
    HashMap<TreeNode , Integer> map=new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int sum1=root.val,sum2=0;
        if(root.left!=null)
        {
            sum1=sum1+rob(root.left.right)+rob(root.left.left);
            sum2+=rob(root.left);
        }
            
        if(root.right!=null){
            sum1= sum1+rob(root.right.right)+rob(root.right.left);
            sum2+=rob(root.right);
        }
        map.put(root,Math.max(sum1,sum2));
        return Math.max(sum1,sum2);
            
        
    }
}
