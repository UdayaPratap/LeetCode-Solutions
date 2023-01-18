/*
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 */


class Solution {
    int cams=0;
    public int minCameraCover(TreeNode root) {
        if(helper(root)==-1)
        cams++;
        return cams;
        
    }
// -1 : if a child returns - 1 to its parent it means it is not covered and it needs a camera
//0: if a child returns 0 to its parent it means it is itself a camera
//1 : if a child return 1 to its parent it means it is not a camera but it is covered by its own child.
    int helper(TreeNode root){
        if(root==null)
            return 1;
        int left=helper(root.left);
        int right=helper(root.right);
        if(left==-1 || right==-1)
        {
            //one of the children need cam, root becomes cam
            cams++; 
            return 0;
        }
        if(left==0|| right==0)
        {
            //either one of children is cam, root also covered, no cam needed at root
            return 1;
        }
        //both children covered, root needs coverage/cam
        return -1;

            
    }
}
