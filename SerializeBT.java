/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
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
        if(root==null) return "$,";
        String left=serialize(root.left);
        String right=serialize(root.right);
        return Integer.toBinaryString(root.val)+","+left+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] arr=data.split(",");
        System.out.println(Arrays.toString(arr));
        return helper(arr, 0);
    }
    TreeNode helper(String[] arr, int i){
        if(i>=arr.length || arr[i].equals("$")) return null;
        TreeNode root=new TreeNode(Integer.parseInt(arr[i],2));
        root.left=helper(arr, 2*i+1);
        root.right=helper(arr, 2*i+2);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
