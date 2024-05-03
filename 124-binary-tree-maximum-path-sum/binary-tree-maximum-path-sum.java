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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the maximum path sum for the left and right subtrees
        int leftSum = Math.max(0, calculateMaxPathSum(node.left));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right));
        
        // Update the maximum path sum encountered so far
        maxSum = Math.max(maxSum, node.val + leftSum + rightSum);
        
        // Return the maximum path sum including the current node
        return node.val + Math.max(leftSum, rightSum);
    }
}