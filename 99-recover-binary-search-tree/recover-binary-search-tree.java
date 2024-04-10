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
    private TreeNode firstMisplaced = null;
    private TreeNode secondMisplaced = null;
    private TreeNode prevNode = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstMisplaced.val;
        firstMisplaced.val = secondMisplaced.val;
        secondMisplaced.val = temp;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        traverse(node.left);

        if (prevNode != null && prevNode.val >= node.val) {
            if (firstMisplaced == null) {
                firstMisplaced = prevNode;
            }
            secondMisplaced = node;
        }
        prevNode = node;

        traverse(node.right);
    }
}