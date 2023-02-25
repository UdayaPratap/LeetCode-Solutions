/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
*/
class Solution {
    TreeNode first=null, second=null, prev=null;
    public void recoverTree(TreeNode root) {
        if(root==null) return;

        //finds nodes to be swapped
        inorder(root);

        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        //find the first node which is at wrong position
        if(first==null && (prev==null ||prev.val>=root.val)){
            first = prev;
        }
        
        //find the second node which is at wrong position
        if(first!=null && prev.val>=root.val){
            second = root;
        }
        prev=root;
        inorder(root.right);
    }
}
