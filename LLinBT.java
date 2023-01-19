/*
Given a binary tree root and a linked list with head as the first node. 

Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean ans=helper(head,root);
        
        if(root!=null && !ans)
           ans=ans|| isSubPath(head,root.left) || isSubPath(head,root.right);
           
        
        return ans;

    }
    boolean helper(ListNode head, TreeNode root)
    {
        if(head==null) return true;
        if(root==null) return false;

        if(root.val==head.val)  return helper(head.next,root.left)|| helper(head.next,root.right);
        
        return false;
    }
}
