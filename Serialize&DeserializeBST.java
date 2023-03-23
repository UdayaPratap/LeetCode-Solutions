/*
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "_";
        String ans=root.val+" "+serialize(root.left)+" "+serialize(root.right);
        return ans;
    }

    // Decodes your encoded data to tree.
    String[] arr; int i;
    public TreeNode deserialize(String data) {
        arr=data.split(" ");
        i=0;
        return join();
    }
    TreeNode join()
    {
        int idx=this.i++;
        if(arr[idx].equals("_")) return null;
        TreeNode root=new TreeNode(Integer.valueOf(arr[idx]));
        root.left=join();
        root.right=join();
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
