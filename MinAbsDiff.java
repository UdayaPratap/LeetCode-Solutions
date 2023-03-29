/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 
 */
class Solution {
    ArrayList<Integer> al = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        int minDist = Integer.MAX_VALUE;
        for(int i = 1 ; i < al.size(); i ++){
            minDist = Math.min(minDist,al.get(i) - al.get(i-1));
        }
        return minDist;
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return ;
        }
        inOrder(root.left);
        al.add(root.val);
        inOrder(root.right);
    }
}
