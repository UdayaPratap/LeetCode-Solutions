/*
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
*/

//APPROACH 1 : STORE INORDER IN ARRAYLIST AND MAKE PTR.
class BSTIterator {
    ArrayList<Integer> inOrder;
    int ptr;
    public BSTIterator(TreeNode root) {
        inOrder=new ArrayList<>();
        inorder(root, inOrder);
        ptr=-1;
        // System.out.println(inOrder.size());
    }
    private void inorder(TreeNode root, ArrayList<Integer> inOrder)
    {
        if(root==null) return;
        inorder(root.left, inOrder);
        inOrder.add(root.val);
        inorder(root.right, inOrder);
    }
    
    public int next() {
        ptr++;
        return ptr==inOrder.size()? -1: inOrder.get(ptr);
    }
    
    public boolean hasNext() {
        return ptr<inOrder.size()-1;
    }
}
//APPROACH 2: DO CONTROLLED INORDER USING STACK INSTEAD OF RECURSION


class BSTIterator {
    Stack<TreeNode> inorder;
    public BSTIterator(TreeNode root) {
        inorder=new Stack<>();
        updateInorder(root);
    }
    
    public int next() {
        TreeNode curr=inorder.pop();
        updateInorder(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !inorder.isEmpty();
    }
    private void updateInorder(TreeNode root)
    {
            while(root!=null)
            {
                inorder.add(root);
                root=root.left;
            }
    }
}

