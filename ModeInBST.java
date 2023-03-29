/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.*/
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    int count = 0;
    int maxCount = Integer.MIN_VALUE;
    TreeNode prev = null;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int size = res.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(prev != null && root.val == prev.val){
            count++;
        }else{
            count = 1;
        }
        if(count == maxCount) res.add(root.val);
        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        prev = root;
        dfs(root.right);
    }
}
