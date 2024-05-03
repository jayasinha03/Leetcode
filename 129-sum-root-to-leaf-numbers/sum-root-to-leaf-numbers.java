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
    public int sumNumbers(TreeNode root) {
      return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Calculate the new sum formed by appending the current node's value
        int newSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return newSum;
        }

        // Recursively calculate the sum for left and right subtrees
        int leftSum = sumNumbers(node.left, newSum);
        int rightSum = sumNumbers(node.right, newSum);

        // Return the total sum of root-to-leaf numbers
        return leftSum + rightSum;  
    }
}