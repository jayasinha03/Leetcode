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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }
        
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }
        
        // Check if the height difference between left and right subtrees is no more than 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current subtree is unbalanced
        }
        
        // Return the height of the current node's subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}