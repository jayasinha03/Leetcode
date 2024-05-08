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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // Recursively flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);
        
        // Store the right subtree in a temporary variable
        TreeNode temp = root.right;
        
        // Move the flattened left subtree to the right
        root.right = root.left;
        root.left = null;
        
        // Find the rightmost node of the current subtree
        while (root.right != null) {
            root = root.right;
        }
        
        // Attach the flattened right subtree to the rightmost node
        root.right = temp;
    }

    // Helper function to print the flattened linked list
    public void printFlattenedList(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }
}